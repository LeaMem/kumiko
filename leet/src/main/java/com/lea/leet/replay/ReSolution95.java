package com.lea.leet.replay;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReSolution95 {

	public List<TreeNode> generateTrees(int n) {
		if(n == 0){
			return Collections.emptyList();
		}
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int l, int r){

		if(l > r){
			List<TreeNode> list = new ArrayList<>();
			list.add(null);
			return list;
		}

		List<TreeNode> list = new ArrayList<>();
		for (int i = l; i<= r; i++){
			//左边
			List<TreeNode> leftTrees = generateTrees(l, i - 1);
			//右边
			List<TreeNode> rightTrees = generateTrees(i + 1, r);
			for (TreeNode leftTree : leftTrees) {
				for (TreeNode rightTree : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftTree;
					root.right = rightTree;
					list.add(root);
				}
			}
		}
		return list;
	}

}
