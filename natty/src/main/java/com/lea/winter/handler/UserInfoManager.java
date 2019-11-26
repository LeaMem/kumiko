package com.lea.winter.handler;

import com.lea.winter.entity.UserInfo;
import com.lea.winter.proto.ChatProto;
import com.lea.winter.util.NettyUtil;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class UserInfoManager {

    private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    public static ConcurrentMap<Channel, UserInfo> userInfos = new ConcurrentHashMap<>();

    private static AtomicInteger userCount = new AtomicInteger(0);

    public static void addChannel(Channel channel){
        String remoteAddr = NettyUtil.parseChannelRemoteAddr(channel);
        if(!channel.isActive()){
            log.error("channel is not active, address: {}", remoteAddr);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setAddr(remoteAddr);
        userInfo.setChannel(channel);
        userInfo.setTime(System.currentTimeMillis());
        userInfos.put(channel, userInfo);
    }

    public static boolean saveUser(Channel channel, String nick){
        UserInfo userInfo = userInfos.get(channel);
        if(userInfo == null){
            return false;
        }
        if(!channel.isActive()){
            log.error("channel is not active, address: {}, nick: {}", userInfo.getAddr(), nick);
            return false;
        }
        //新增一个认证用户
        userCount.incrementAndGet();
        userInfo.setNick(nick);
        userInfo.setAuth(true);
        userInfo.setUserId();
        userInfo.setTime(System.currentTimeMillis());
        return true;
    }

    /**
     *      从缓存中移除 Channel, 并且关闭 Channel
     */
    public static void removeChannel(Channel channel){
        try{
            log.warn("channel will be remove, address is : {}", NettyUtil.parseChannelRemoteAddr(channel));
            rwLock.writeLock().lock();
            channel.close();
            UserInfo userInfo = userInfos.get(channel);
            if(userInfo != null){
                UserInfo tmp = userInfos.remove(channel);
                if(tmp != null && tmp.isAuth()){
                    //减去一个认证用户
                    userCount.decrementAndGet();
                }
            }
        }finally {
            rwLock.writeLock().unlock();
        }
    }


    /**
     *      广播普通消息
     * @param uid
     * @param nick
     * @param message
     */
    public static void broadcastMess(int uid, String nick, String message){
        if(!StringUtils.isEmpty(message)){
            try{
                rwLock.readLock().lock();
                Set<Channel> keySet = userInfos.keySet();
                for(Channel channel: keySet){
                    UserInfo userInfo = userInfos.get(channel);
                    if(userInfo == null || !userInfo.isAuth()){
                        continue;
                    }
                    channel.writeAndFlush(new TextWebSocketFrame(ChatProto.buildMessProto(uid, nick, message)));

                }
            }finally {
                rwLock.readLock().unlock();
            }
        }
    }

    /**
     *      广播系统消息
     * @param code
     * @param mess
     */
    public static void broadcastInfo(int code, Object mess){
        try{
            rwLock.readLock().lock();
            Set<Channel> keySet = userInfos.keySet();
            for(Channel channel : keySet){
                UserInfo userInfo = userInfos.get(channel);
                if(userInfo == null || !userInfo.isAuth()){
                    continue;
                }
                channel.writeAndFlush(new TextWebSocketFrame(ChatProto.buildSysProto(code, mess)));
            }
        }finally {
            rwLock.readLock().unlock();
        }
    }

    /**
     *      发送系统消息
     * @param channel
     * @param code
     * @param mess
     */
    public static void sendInfo(Channel channel, int code, Object mess){
        channel.writeAndFlush(new TextWebSocketFrame(ChatProto.buildSysProto(code, mess)));
    }


    /**
     *      扫描甘比失效的Channel
     */
    public static void scanNotActiveChannel(){
        Set<Channel> keySet = userInfos.keySet();
        for(Channel channel : keySet){
            UserInfo userInfo = userInfos.get(channel);
            if(userInfo == null){
                continue;
            }
            if(!channel.isOpen() || !channel.isActive() || (!userInfo.isAuth() &&
                    (System.currentTimeMillis() - userInfo.getTime() > 10000))){
                removeChannel(channel);
            }
        }
    }

    public static void broadCastPing(){
        try{
            rwLock.readLock().lock();
            log.info("broadCastPing userCount: {}", userCount.intValue());
            Set<Channel> keySet = userInfos.keySet();
            for(Channel ch : keySet){
                UserInfo userInfo = userInfos.get(ch);
                if(userInfo == null || !userInfo.isAuth()){
                    continue;
                }
                ch.writeAndFlush(new TextWebSocketFrame(ChatProto.buildPingProto()));
            }
        }finally {
            rwLock.readLock().unlock();
        }
    }

    public static UserInfo getUserInfo(Channel channel){
        return userInfos.get(channel);
    }

    public static int getAuthUserCount(){
        return userCount.get();
    }

    public static void updateUserTime(Channel channel){
        UserInfo userInfo = getUserInfo(channel);
        if(userInfo != null){
            userInfo.setTime(System.currentTimeMillis());
        }
    }
}
