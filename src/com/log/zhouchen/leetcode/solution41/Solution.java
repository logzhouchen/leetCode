package com.log.zhouchen.leetcode.solution41;

/**
 * @author: shenzhouchen
 * @date: 2021/6/10 8:59 AM
 **/
public class Solution {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int i = 0;
        while(i < nums.length) {

            // 我们只需要check [1, nums.length] 区间数字
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = -1;
                i++;
                continue;
            }

            // 适应数组下标，从0开始
            int index = nums[i] - 1;
            if (index == i) {
                // 已经在目标位置了
                i++;
            } else if (index < i) {
                // 在已经遍历过的位置，直接归位，当前位置置空，不用担心把原始数据覆盖掉
                nums[index] = nums[i];
                nums[i] = -1;
                i++;
            } else {

                if (nums[index] == nums[i]) {
                    // 目标位置已经是目标值了
                    nums[i] = -1;
                } else {
                    swap(nums, i, index);
                }
            }
        }

        int rs = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == -1) {
                rs = j + 1;
                break;
            }
        }
        if (rs == -1) {
            rs = nums.length + 1;
        }

        return rs;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.firstMissingPositive(new int[]{2, 2}));
        System.out.println(solution.firstMissingPositive(new int[]{-1}));
    }
}
