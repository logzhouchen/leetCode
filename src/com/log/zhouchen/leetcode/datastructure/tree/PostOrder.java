package com.log.zhouchen.leetcode.datastructure.tree;

import java.util.Stack;

/**
 * @author: shenzhouchen
 * @date: 2021/4/7 11:53 PM
 **/
public class PostOrder {

    public void printTreeInRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        printTreeInRecursive(root.getLeft());
        printTreeInRecursive(root.getRight());
        System.out.println(root.getValue());
    }


    public void printTreeInLoop(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> flagStack = new Stack<>();

        while (!nodeStack.isEmpty() || root != null) {
            if (root != null) {
                nodeStack.push(root);
                flagStack.push(0);
                root = root.getLeft();
                continue;
            }

            Integer flag = flagStack.pop();
            if (flag == 0) {
                root = nodeStack.peek().getRight();
                flagStack.push(1);
            } else {
                root = nodeStack.pop();
                System.out.println(root.getValue());
                root = null;
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

        PostOrder solution = new PostOrder();
        solution.printTreeInLoop(root);
    }
}
