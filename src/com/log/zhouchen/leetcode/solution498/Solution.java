package com.log.zhouchen.leetcode.solution498;

/**
 * @author: shenzhouchen
 * @date: 2021/5/27 12:30 AM
 **/
public class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length, column = mat[0].length;
        int[] res = new int[row * column];
        int index = 0;

        int large = Math.max(row, column);
        int allRound = (large - 1) * 2 + 1;
        // 轮次，偶数轮从左下 -> 右上，奇数轮从右上 -> 左下
        for(int round = 0; round < allRound; round++) {

            // 每一轮 i + j = round
            if (round % 2 == 0) {
                for (int i = round; i >= 0; i--) {
                    int j = round - i;

                    if (j >= column) {
                        break;
                    }
                    if (i >= row) {
                        continue;
                    }

                    res[index++] = mat[i][j];
                }

            } else {
                for (int i = 0; i <= round; i++) {
                    int j = round - i;

                    if (i >= row) {
                        break;
                    }
                    if (j >= column) {
                        continue;
                    }

                    res[index++] = mat[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[3][3];
        mat[0] = new int[]{1, 2, 3};
        mat[1] = new int[]{4, 5, 6};
        mat[2] = new int[]{7, 8, 9};

        Solution solution = new Solution();
        int[] res = solution.findDiagonalOrder(mat);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
