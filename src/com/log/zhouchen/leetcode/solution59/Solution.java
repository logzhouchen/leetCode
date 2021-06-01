package com.log.zhouchen.leetcode.solution59;

/**
 * @author: shenzhouchen
 * @date: 2021/6/2 12:10 AM
 **/
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int num = 1, max = n * n;
        int i = 0, j = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;

        while (num <= max) {
            res[i][j] = num;
            num++;

            int tempI = i + directions[direction % 4][0];
            int tempJ = j + directions[direction % 4][1];
            if (tempI < 0 || tempI >= n || tempJ < 0 || tempJ >= n
                    || res[tempI][tempJ] > 0) {
                direction++;

                tempI = i + directions[direction % 4][0];
                tempJ = j + directions[direction % 4][1];
            }
            i = tempI;
            j = tempJ;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] res = new Solution().generateMatrix(3);
        System.out.println(res);
    }
}
