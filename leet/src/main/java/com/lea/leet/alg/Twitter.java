package com.lea.leet.alg;

import java.util.*;

/**
 *      擦，这里可以用广度优先搜索，我这里还是遍历了所有节点，真的好笨哦
 */
public class Twitter {

    private Map<Integer, User> userMap = new HashMap<>();

    public Long timestamp = 1L;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {


        //todo 判断map有没有这个人
        if (!this.userMap.containsKey(userId)) {
            User user = new User();
            user.userId = userId;
            this.userMap.put(userId, user);
        }

        User user = userMap.get(userId);
        user.addTweet(tweetId, timestamp++);

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        //最大堆
        PriorityQueue<Tweet> queue = new PriorityQueue<>(Comparator.comparing(o -> o.timestamp));

        User user = this.userMap.get(userId);

        if(user == null){
            return new ArrayList<>();
        }

        Set<Integer> set = new HashSet<>(user.following);
        set.add(user.userId);

        for (Integer uId : set) {
            User followee = this.userMap.get(uId);

            List<Tweet> list = followee.list;

            for(Tweet tweet : list){
                if (queue.size() < 10) {
                    queue.add(tweet);
                } else {
                    if (queue.peek().timestamp.compareTo(tweet.timestamp) < 0) {
                        queue.poll();
                        queue.add(tweet);
                    }
                }
            }

        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().tweetId);
        }

        Collections.reverse(list);
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

        //如果有
        if(!this.userMap.containsKey(followerId)){
            User user = new User();
            user.userId = followerId;
            this.userMap.put(followerId, user);
        }

        if(!this.userMap.containsKey(followeeId)){
            User user = new User();
            user.userId = followeeId;
            this.userMap.put(followeeId, user);
        }

        this.userMap.get(followerId).follow(followeeId);


    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User user = userMap.get(followerId);
            user.unFollow(followeeId);
        }
    }

    /**
     * 用户类
     */
    public static class User {

        //用户id
        public Integer userId;

        //用户关注的人
        public Set<Integer> following = new HashSet<>();

        public List<Tweet> list = new ArrayList<>();

        public void addTweet(Integer tweetId, Long timestamp) {
            Tweet tmp = new Tweet();
            tmp.timestamp = timestamp;
            tmp.tweetId = tweetId;

            list.add(tmp);
        }

        public void follow(Integer userId) {
            if (!userId.equals(this.userId)) {
                this.following.add(userId);
            }
        }

        public void unFollow(Integer userId) {
            this.following.remove(userId);
        }

    }

    public static class Tweet {

        public Long timestamp;

        public Integer tweetId;

    }


    public static void main(String[] args) {

        //[null,null,[5],null,null,[6,5],null,[5]]

        Twitter twitter = new Twitter();

        List<Integer> newsFeed = twitter.getNewsFeed(1);

//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//        twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
////        twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//        Map<Integer, User> userMap = twitter.userMap;
//        twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//        twitter.getNewsFeed(1);
    }


}
