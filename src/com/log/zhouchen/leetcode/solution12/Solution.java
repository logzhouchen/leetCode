package com.log.zhouchen.leetcode.solution12;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: shenzhouchen
 * @date: 2021/3/25 12:19 AM
 **/
public class Solution {

    private static LinkedHashMap<Integer, String> dividorMapping = new LinkedHashMap<>();
    static {
        dividorMapping.put(1000, "M");
        dividorMapping.put(900, "CM");
        dividorMapping.put(500, "D");
        dividorMapping.put(400, "CD");
        dividorMapping.put(100, "C");
        dividorMapping.put(90, "XC");
        dividorMapping.put(50, "L");
        dividorMapping.put(40, "XL");
        dividorMapping.put(10, "X");
        dividorMapping.put(9, "IX");
        dividorMapping.put(5, "V");
        dividorMapping.put(4, "IV");
        dividorMapping.put(1, "I");
    }

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : dividorMapping.entrySet()) {
            int beishu = num / entry.getKey();
            if (beishu >= 1) {
                for (int i = 0; i < beishu; i++) {
                    sb.append(entry.getValue());
                }
                num = num % entry.getKey();
            }

            if (num == 0) {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }
}
