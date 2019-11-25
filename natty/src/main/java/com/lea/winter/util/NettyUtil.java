package com.lea.winter.util;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.net.SocketAddress;


@Slf4j
public class NettyUtil {

    public static String parseChannelRemoteAddr(final Channel channel){
        if(null == channel){
            return "";
        }
        SocketAddress remote = channel.remoteAddress();
        final String addr = remote != null ? remote.toString() : "";

        log.info("远程的地址是 [{}] [{}]", addr, addr.toString());

        if(addr.length() > 0){
            int index = addr.lastIndexOf("/");
            if(index >= 0){
                return addr.substring(index + 1);
            }

            return addr;
        }
        return "";
    }

}
