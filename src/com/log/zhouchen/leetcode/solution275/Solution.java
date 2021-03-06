package com.log.zhouchen.leetcode.solution275;

/**
 * @author: shenzhouchen
 * @date: 2021/2/15 8:59 PM
 **/
public class Solution {

    public int hIndex(int[] citations) {
        // check on input
        if (citations == null || citations.length == 0) {
            return 0;
        }

        // basic in DESC order
        int[] array = reverse(citations);

        // find the largest h
        int result = 0;
        int i = 0, j = array.length - 1;
        int middle = (i + j) / 2;
        while (true && i <= j) {
            if (array[middle] > middle) {
                result = middle + 1;
                i = middle + 1;
            } else {
                j = middle - 1;
            }

            middle = (i + j) / 2;
        }

        return result;
    }

    private int[] reverse(int[] array) {
        int length = array.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = array[length - 1 - i];
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{0, 1, 3, 5, 6};

        System.out.println(solution.hIndex(array));
    }
}
