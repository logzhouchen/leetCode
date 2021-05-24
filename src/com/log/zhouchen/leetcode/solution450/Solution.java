package com.log.zhouchen.leetcode.solution450;

/**
 * @author: shenzhouchen
 * @date: 2021/5/24 10:18 PM
 **/
public class Solution {

    /**
     * 递归方式
     */
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode1(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode1(root.right, key);
        } else {
            root = reArrangeNode(root);
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode node = root, parent = root;
        // -1 表示左，1表示右
        int leftOrRight = -1;

        while (node != null && node.val != key) {
            parent = node;
            if (node.val < key) {
                node = node.right;
                leftOrRight = 1;
            } else {
                node = node.left;
                leftOrRight = -1;
            }
        }


        TreeNode newNode = reArrangeNode(node);
        if (node == root) {
            return newNode;
        } else {
            if (leftOrRight == -1) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            return root;
        }
    }

    private TreeNode reArrangeNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return null;

        } else if (node.left == null) {
            return node.right;

        } else if (node.right == null) {
            return node.left;
        } else {
            TreeNode temp = node.left;
            if (temp.right == null) {
                temp.right = node.right;
                return temp;
            } else {
                // 找到左子树 最大的节点last，及其父节点 temp
                TreeNode last = temp;
                while (last.right != null) {
                    temp = last;
                    last = last.right;
                }

                // 最大的节点last的左子树 前提
                temp.right = last.left;

                // 将last放入node位置
                last.left = node.left;
                last.right = node.right;
                return last;
            }
        }
    }

    //5 3 6 2 4 null 7
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);

        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        n5.left = n3;
        n5.right = n6;

        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        n3.left = n2;
        n3.right = n4;

        TreeNode n7 = new TreeNode(7);
        n6.right = n7;

        TreeNode result = new Solution().deleteNode(n5, 0);
        System.out.println(result);
    }
}
