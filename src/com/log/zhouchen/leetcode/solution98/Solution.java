package com.log.zhouchen.leetcode.solution98;

/**
 * @author: shenzhouchen
 * @date: 2021/5/21 1:50 AM
 **/
public class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST(root.left, Long.MIN_VALUE, root.val)
                && isValidBST(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val > min && node.val < max) {
            return isValidBST(node.left, min, node.val)
                    && isValidBST(node.right, node.val, max);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
