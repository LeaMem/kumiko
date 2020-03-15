package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution1379 {


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }

        if(original == target){
            return cloned;
        }

        TreeNode result = getTargetCopy(original.left, cloned.left, target);

        if(result != null){
            return result;
        }

        result = getTargetCopy(original.right, cloned.right, target);

        if(result != null){
            return result;
        }

        return null;

    }


}
