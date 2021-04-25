package com.log.zhouchen.leetcode.solution40;

import java.util.*;

/**
 * @author: shenzhouchen
 * @date: 2021/4/11 11:23 PM
 **/
public class Solution {

    /**
     * 无重复数字 + 可重复无限次 + 都是正数
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();


        Arrays.sort(candidates);
        findtargetComInRecurrsive(result, new ArrayList<>(), candidates, 0, target);

        return result;
    }

    private void findtargetComInRecurrsive(List<List<Integer>> result, List<Integer> list, int[] candidates, int start, int target) {
        // copy，不污染上层逻辑
        List<Integer> thisone = new ArrayList<>(list);
        if (target == 0) {
            result.add(thisone);
            return;
        }

        Set<Integer> processed = new HashSet<>();
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (processed.contains(candidates[i])) {
                continue;
            }

            thisone.add(candidates[i]);

            findtargetComInRecurrsive(result, thisone, candidates, i + 1, target - candidates[i]);

            thisone.remove(thisone.size() - 1);
            processed.add(candidates[i]);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2,5,2,1,2};
        solution.print(solution.combinationSum2(nums, 5));
    }

    private void print(List<List<Integer>> result) {
        result.stream().forEach(list -> System.out.println(list));
    }
}
