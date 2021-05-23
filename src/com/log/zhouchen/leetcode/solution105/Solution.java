package com.log.zhouchen.leetcode.solution105;

import java.util.Arrays;

/**
 * @author: shenzhouchen
 * @date: 2021/5/16 2:16 PM
 *
 * 假设无重复元素
 **/
public class Solution {

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        return buildSubTree(preorder, 0, inorder, 0, preorder.length);
    }

    /**
     * preOrder:    [preStart, preStart + length)
     * inOrder:     [inStart, inStart + length)
     */
    private TreeNode buildSubTree(int[] preorder, int preStart, int[] inorder, int inStart, int length) {
        if (length <= 0 || preStart >= preorder.length || inStart >= inorder.length) {
            return null;
        }

        int rootVal = preorder[preStart];

        int i = inStart;
        for (; i < inStart + length; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }
        int leftLength = i - inStart;
        int rightLength = inStart + length - i - 1;

        TreeNode left = buildSubTree(preorder, preStart + 1, inorder, inStart, leftLength);
        TreeNode right = buildSubTree(preorder, preStart + 1 + leftLength, inorder, i + 1, rightLength);

        return new TreeNode(rootVal, left, right);
    }


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        int rootval = preorder[0];
        int targetIndex = 0;
        for (; targetIndex < inorder.length; targetIndex++) {
            if (inorder[targetIndex] == rootval) {
                break;
            }
        }

        TreeNode left = buildTree2(Arrays.copyOfRange(preorder, 1, 1 + targetIndex), Arrays.copyOfRange(inorder, 0, targetIndex));
        TreeNode right = buildTree2(Arrays.copyOfRange(preorder, 1 + targetIndex, preorder.length), Arrays.copyOfRange(inorder, targetIndex + 1, inorder.length));

        return new TreeNode(rootval, left, right);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree2(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root);
    }
}
