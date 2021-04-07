package com.log.zhouchen.leetcode.datastructure.tree;

import java.util.Stack;

/**
 * @author: shenzhouchen
 * @date: 2021/4/7 1:02 AM
 *
 * Root -> L -> R
 **/
public class PreOrder {

    public void printTreeInRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.getValue());
        printTreeInRecursive(root.getLeft());
        printTreeInRecursive(root.getRight());
    }

    public void printTreeInLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current.getValue());

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }


    public static void main(String[] args) {

        TreeNode right3 = new TreeNode(10);

        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(4);

        TreeNode left1 = new TreeNode(3, left2, right2);
        TreeNode right1 = new TreeNode(9, null, right3);
        TreeNode root = new TreeNode(6, left1, right1);

        PreOrder solution = new PreOrder();
        solution.printTreeInLoop(root);
    }
}
