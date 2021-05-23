package com.log.zhouchen.leetcode.solution101;

/**
 * @author: shenzhouchen
 * @date: 2021/5/21 12:57 AM
 **/
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
