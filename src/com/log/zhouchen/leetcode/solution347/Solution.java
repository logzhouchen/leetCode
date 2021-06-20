package com.log.zhouchen.leetcode.solution347;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenzhouchen
 * @date: 2021/6/17 10:11 PM
 **/
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int[] array = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[i++] = entry.getKey();
        }
        for (int j = map.size() / 2; j >= 0; j--) {
            maxifyHeap(array, j, map.size(), map);
        }

        int[] res = new int[k];
        for (int m = 0, size = map.size(); m < k; m++, size--) {
            res[m] = array[0];
            swap(array, 0, size - 1);
            maxifyHeap(array, 0, size - 1, map);
        }

        return res;
    }


    private void maxifyHeap(int[] array, int i, int size, Map<Integer, Integer> map) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int max = i;

        if (l < size && map.get(array[l]) > map.get(array[max])) {
            max = l;
        }
        if (r < size && map.get(array[r]) > map.get(array[max])) {
            max = r;
        }

        if (max != i) {
            swap(array, max, i);
            maxifyHeap(array, max, size, map);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};

        Solution solution = new Solution();
        int[] res = solution.topKFrequent(nums, 1);

        for (int num : res) {
            System.out.println(num);
        }
    }
}
