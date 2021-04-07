package com.log.zhouchen.leetcode.datastructure.tree;

import java.util.Stack;

/**
 * @author: shenzhouchen
 * @date: 2021/4/7 11:38 PM
 **/
public class InOrder {
    public void printTreeInRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        printTreeInRecursive(root.getLeft());
        System.out.println(root.getValue());
        printTreeInRecursive(root.getRight());
    }

    public void printTreeInLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.getLeft();
                continue;
            }

            TreeNode toProcess = stack.pop();
            System.out.println(toProcess.getValue());
            root = toProcess.getRight();
        }
    }

    public static void main(String[] args) {

        TreeNode right3 = new TreeNode(10);

        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(4);

        TreeNode left1 = new TreeNode(3, left2, right2);
        TreeNode right1 = new TreeNode(9, null, right3);
        TreeNode root = new TreeNode(6, left1, right1);

        InOrder solution = new InOrder();
        solution.printTreeInLoop(root);
    }
}
