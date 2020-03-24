package com.lea.leet.alg;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer>  set = new HashSet<>();
        for(int it : nums){
            if(set.contains(it)){
                return true;
            }else {
                set.add(it);
            }
        }

        return false;
    }

}
