package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://www.codenong.com/cs106052376/
 */
public class Solution863 {

    //solution 1 模仿数组形式的threadLocal
    //solution 2 bfs 上，左，右深度优先遍历
    //solution 3 坐标化
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(root, map, 0);
        for (Entry<TreeNode, Integer> entry : map.entrySet()) {
            Integer ti = map.get(target);
            Integer pi = entry.getValue();
            int ans = 0;
            while (!ti.equals(pi)) {
                if (ti > pi) {
                    ti = (ti - 1) / 2;
                } else {
                    pi = (pi - 1) / 2;
                }
                ans++;
            }
            if (ans == K) {
                list.add(entry.getKey().val);
            }
        }

        return list;
    }

    public void dfs(TreeNode root, Map<TreeNode, Integer> map, Integer height) {
        if (root == null) {
            return;
        }
        map.put(root, height);
        dfs(root.left, map, 2 * height + 1);
        dfs(root.right, map, 2 * height + 2);
    }

}
