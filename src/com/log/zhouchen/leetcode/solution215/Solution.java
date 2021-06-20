package com.log.zhouchen.leetcode.solution215;

import java.util.Arrays;

/**
 * @author: shenzhouchen
 * @date: 2021/6/17 9:35 PM
 **/
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        // 默认都是 Integer.MIN_VALUE
        int[] array = new int[k];
        Arrays.fill(array, Integer.MIN_VALUE);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= array[0]) {
                // 进不了最小堆
                continue;
            }
            array[0] = nums[i];
            minifyHeap(array, 0);
        }

        return array[0];
    }

    private void minifyHeap(int[] array, int i) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int min = i;

        if (l < array.length && array[l] < array[min]) {
            min = l;
        }
        if (r < array.length && array[r] < array[min]) {
            min = r;
        }

        if (min != i) {
            swap(array, min, i);
            minifyHeap(array, min);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3};

        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, 1));
    }
}
