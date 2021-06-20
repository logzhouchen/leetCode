package com.log.zhouchen.leetcode.solution278;

/**
 * @author: shenzhouchen
 * @date: 2021/6/13 11:22 PM
 **/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i <= j) {
            int mid = i + ((j - i) >> 2);

            if (isBadVersion(mid)) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        double doubleRs = (7.9d + 8d) / 2;

        System.out.println((int) (doubleRs));
        System.out.println(Integer.parseInt(new java.text.DecimalFormat("0").format(doubleRs)));
    }
}
