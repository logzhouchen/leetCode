package com.log.zhouchen.leetcode.sort;

/**
 * @author: shenzhouchen
 * @date: 2020/1/27 2:01 PM
 **/
public class QuickSort {

    public void quickSort(int[] array, int start, int end) {
        // 递归结束条件
        if (start >= end) {
            return;
        }

        int flag = array[start];
        int m = start, n = end;
        while (m <= n) {
            while (m <= n && array[m] <= flag) {
                m++;
            }
            while (n >= m && array[n] > flag) {
                n--;
            }

            if (m < n) {
                swap(array, m, n);
            }
        }

        if (n > start) {
            swap(array, n, start);
        }
        quickSort(array, start, n - 1);
        quickSort(array, n + 1, end);
    }

    /**
     * 交换数组i, j顺序
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int length = 10;
        int upLimit = 100;

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * upLimit);
        }

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, length -1);

        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
}
