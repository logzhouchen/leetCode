package com.log.zhouchen.leetcode.solution101;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: shenzhouchen
 * @date: 2021/5/21 12:57 AM
 **/
public class Solution {

    /**
     * 递归解法
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 循环解法
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            }
            queue.offer(n1.left);
            queue.offer(n2.right);

            queue.offer(n1.right);
            queue.offer(n2.left);
        }

        return true;
    }
}
