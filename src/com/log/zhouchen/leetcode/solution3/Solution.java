package com.log.zhouchen.leetcode.solution3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenzhouchen
 * @date: 2021/6/2 12:18 AM
 **/
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        int i = 0, max = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            if (indexMap.containsKey(ch) && indexMap.get(ch) >= i) {
                i = indexMap.get(ch) + 1;
            }

            max = Math.max(max, j - i + 1);
            indexMap.put(ch, j);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }
}
