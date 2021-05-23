package com.log.zhouchen.leetcode.solution105;

/**
 * @author: shenzhouchen
 * @date: 2021/5/16 2:17 PM
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
