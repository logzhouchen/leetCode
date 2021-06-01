package com.log.zhouchen.leetcode.solution54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenzhouchen
 * @date: 2021/6/1 11:46 PM
 **/
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length, n = matrix[0].length, size = m * n;
        int[][] visited = new int[m][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int i = 0, j = 0, direction = 0;
        while (result.size() < size) {
            result.add(matrix[i][j]);
            visited[i][j] = 1;

            int tempI = i + directions[direction % 4][0];
            int tempJ = j + directions[direction % 4][1];
            if (tempI < 0 || tempI >= m || tempJ < 0 || tempJ >= n
                    || visited[tempI][tempJ] == 1) {
                direction++;
                tempI = i + directions[direction % 4][0];
                tempJ = j + directions[direction % 4][1];
            }
            i = tempI;
            j = tempJ;
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(array));
    }
}
