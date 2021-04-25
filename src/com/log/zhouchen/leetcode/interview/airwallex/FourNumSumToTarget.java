package com.log.zhouchen.leetcode.interview.airwallex;

import java.util.*;

/**
 * @author: shenzhouchen
 * @date: 2021/4/21 12:23 AM
 *
 * airwallex
 * 数组中数字不重复；找出4个数字之和为taget的所有组合
 *
 * o(n^2)  不重复
 **/
public class FourNumSumToTarget {


    public List<List<Integer>> findFourNums(int[] arrays, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (arrays == null || arrays.length < 4) {
            return result;
        }

        // o(n^2)
        Map<Integer, List<IntegerPair>> map = new HashMap<>();
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                IntegerPair pair = new IntegerPair(arrays[i], arrays[j]);

                List<IntegerPair> pairList = map.get(pair.sum());
                if (pairList == null) {
                    pairList = new ArrayList<>();
                    map.put(pair.sum(), pairList);
                }
                pairList.add(pair);
            }
        }

        Set<Integer> executed = new HashSet<>();
        for (Map.Entry<Integer, List<IntegerPair>> entry : map.entrySet()) {
            int tempSum = entry.getKey(), left = target - tempSum;
            if (executed.contains(tempSum) || executed.contains(left)) {
                continue;
            }

            if (!map.containsKey(left)) {
                continue;
            }
            executed.add(tempSum);
            executed.add(left);

            for (IntegerPair pairA : entry.getValue()) {
                for (IntegerPair pairB : map.get(left)) {
                    if (pairA.distinct(pairB)) {

                        List<Integer> list = new ArrayList<>();
                        list.add(pairA.x);
                        list.add(pairA.y);
                        list.add(pairB.x);
                        list.add(pairB.y);

                        result.add(list);
                    }
                }
            }
        }

        return result;
    }

    static class IntegerPair {
        private int x;

        private int y;

        public IntegerPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private boolean distinct(IntegerPair pair) {
            return x != pair.x && x != pair.y
                    && y != pair.x && y != pair.y;
        }

        private int sum() {
            return x + y;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 6, -2, -6, 7, 11};

        FourNumSumToTarget solution = new FourNumSumToTarget();
        System.out.println(solution.findFourNums(array, 5));
    }
}
