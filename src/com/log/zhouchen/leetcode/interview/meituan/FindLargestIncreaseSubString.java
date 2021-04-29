package com.log.zhouchen.leetcode.interview.meituan;

/**
 * @author: shenzhouchen
 * @date: 2021/4/28 10:21 PM
 *
 * 97612345456789
 * 数字组成的字符串，找出其中最长的递增（相等也不允许）子字符串
 **/
public class FindLargestIncreaseSubString {

    private int findLargestIncreaseSubString(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int maxEndIndex = 1;
        int[] beginIndex = new int[str.length()];
        beginIndex[0] = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) > str.charAt(i - 1)) {
                beginIndex[i] = beginIndex[i - 1];

                if (i - beginIndex[i] + 1 > maxEndIndex - beginIndex[maxEndIndex] + 1) {
                    maxEndIndex = i;
                }
            } else {
                beginIndex[i] = i;
            }
        }

        for (int i = beginIndex[maxEndIndex]; i <= maxEndIndex; i++) {
            System.out.println(str.charAt(i));
        }

        return maxEndIndex - beginIndex[maxEndIndex] + 1;
    }

    public static void main(String[] args) {
        FindLargestIncreaseSubString solution = new FindLargestIncreaseSubString();
        System.out.println(solution.findLargestIncreaseSubString("97612345456789"));
    }
}
