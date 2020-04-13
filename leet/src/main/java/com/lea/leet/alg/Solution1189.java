package com.lea.leet.alg;

import java.util.HashMap;
import java.util.Map;

public class Solution1189 {

    //balloon
    // b 1, a 1, l 2, o 2, n 1
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : text.toCharArray()){
            if(map.containsKey(ch)){
                int cnt = map.get(ch);
                map.put(ch, cnt + 1);
            }else{
                map.put(ch, 1);
            }
        }

        int it = Integer.MAX_VALUE;
        it = Math.min(it, getCnt('a', map));
        it = Math.min(it, getCnt('b', map));
        it = Math.min(it, getCnt('l', map) / 2);
        it = Math.min(it, getCnt('o', map) / 2);
        return Math.min(it, getCnt('n', map));
    }

    public int getCnt(Character key, Map<Character, Integer> map){
        Integer cnt = map.get(key);
        if(cnt == null){
            return 0;
        }
        return cnt;
    }

    public static void main(String[] args) {

//        new Solution1189().maxNumberOfBalloons()
    }
}
