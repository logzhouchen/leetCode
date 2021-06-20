package com.log.zhouchen.leetcode.solution885;

/**
 * @author: shenzhouchen
 * @date: 2021/6/3 12:00 AM
 **/
public class Solution {


    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int sum = rows * cols;
        int[][] res = new int[sum][2];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        res[0] = new int[]{rStart, cStart};
        int num = 1, direction = 0;
        int x = rStart, y = cStart;
        int LEFT = cStart - 1, RIGHT = cStart + 1, UP = rStart - 1, BOTTOM = rStart + 1;

        while (num < sum) {
            if (direction == 0 && y == RIGHT) {
                direction++;
                RIGHT++;
            } else if (direction == 1 && x == BOTTOM) {
                direction++;
                BOTTOM++;
            } else if (direction == 2 && y == LEFT) {
                direction++;
                LEFT--;
            } else if (direction == 3 && x == UP) {
                direction = 0;
                UP--;
            }

            x = x + directions[direction % 4][0];
            y = y + directions[direction % 4][1];

            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                res[num++] = new int[]{x, y};
            }
        }

        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.spiralMatrixIII(5, 6, 1, 4);
        for (int[] item : res) {
            System.out.println(item[0] + " " + item[1]);
        }
    }
}
