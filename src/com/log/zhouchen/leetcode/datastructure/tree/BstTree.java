package com.log.zhouchen.leetcode.datastructure.tree;

/**
 * @author: shenzhouchen
 * @date: 2021/4/8 12:08 AM
 **/
public class BstTree {

    /**
     * 在二叉搜索树中删除目标节点
     */
    public TreeNode deleteTargetNode(TreeNode head, int target) {
        if (head == null) {
            return null;
        }

        if (head.getValue() > target) {
            head.setLeft(deleteTargetNode(head.getLeft(), target));
            return head;

        } else if (head.getValue() < target) {
            head.setRight(deleteTargetNode(head.getRight(), target));
            return head;

        } else {
            TreeNode left = head.getLeft();
            TreeNode right = head.getRight();

            head.setLeft(null);
            head.setRight(null);

            if (left != null) {
                if (right != null) {
                    TreeNode temp = left;
                    while (temp.getRight() != null) {
                        temp = temp.getRight();
                    }
                    temp.setRight(right);
                }
                return left;
            } else {
                return right;
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

        InOrder solution = new InOrder();

        BstTree bstTree = new BstTree();
        root = bstTree.deleteTargetNode(root, 6);
        solution.printTreeInLoop(root);
    }
}
