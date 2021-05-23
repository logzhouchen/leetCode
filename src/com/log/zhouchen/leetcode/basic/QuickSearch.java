package com.log.zhouchen.leetcode.basic;

/**
 * @author: shenzhouchen
 * @date: 2021/5/17 8:48 AM
 **/
public class QuickSearch {

    private int quickSearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int i = 0, j = array.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 8, 16, 22, 100, 101};

        QuickSearch quickSearch = new QuickSearch();
        System.out.println(quickSearch.quickSearch(array, 102));
    }
}
