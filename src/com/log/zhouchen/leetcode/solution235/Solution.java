package com.log.zhouchen.leetcode.solution235;

/**
 * @author: shenzhouchen
 * @date: 2021/5/23 11:01 PM
 **/
public class Solution {

    /**
     * p/q不相等 且肯定存在于root代表的BST树中
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = p.val <= q.val ? p.val : q.val;
        int max = p.val <= q.val ? q.val : p.val;

        if (min < root.val && max < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (min > root.val && max > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
