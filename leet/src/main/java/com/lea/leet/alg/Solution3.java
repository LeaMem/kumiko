package com.lea.leet.alg;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int lengthOfLongestSubstring(String s){

        int max = 0;
        //start
        int left = 0;
        //key 是 character, value 是 索引位置
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


//    public int lengthOfLongestSubstring(String s) {
//
//        int max = 0;
//        Deque<Character> queue = new LinkedList<>();
//
//        for(Character ch : s.toCharArray()){
//            if(queue.isEmpty()){
//                queue.add(ch);
//            }else{
//                if(queue.contains(ch)){
//                    while(!queue.isEmpty() && queue.peek() != ch){
//                        queue.poll();
//                    }
//                    if(!queue.isEmpty() && queue.peek() == ch){
//                        queue.poll();
//                    }
//                }
//                queue.add(ch);
//            }
//
//            max = Math.max(queue.size(), max);
//        }
//
//        return max;
//    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("pwwkew"));
    }

}
