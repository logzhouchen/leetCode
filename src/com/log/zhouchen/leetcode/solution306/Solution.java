package com.log.zhouchen.leetcode.solution306;

/**
 * @author: shenzhouchen
 * @date: 2021/2/15 9:14 PM
 **/
public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() <= 2) {
            return false;
        }

        boolean result = false;
        for (int i = 1; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {

                if (toFlashBack(num, 0, i, j)) {
                    return true;
                }
            }
        }

        return result;
    }

    private boolean toFlashBack(String num, int i, int j, int k) {
        // 递归结束条件
        if (k == num.length()) {
            return true;
        }

        int rs = sumEqual(num, i, j, k);
        if (rs == -1) {
            // 当前不满足，则直接返回
            return false;
        }
        // 当前满足，则继续往下验证
        return toFlashBack(num, j, k, rs);
    }

    private int sumEqual(String num, int i, int j, int k) {
        String one = num.substring(i, j);
        String two = num.substring(j, k);

        // 剪枝，0->OK  01->No
        if (one.startsWith("0") && j - i > 1) {
            return -1;
        }
        if (two.startsWith("0") && k - j > 1) {
            return -1;
        }

        String sum = addOnString(one, two);
        int size = sum.length();
        if (size + k > num.length()) {
            return -1;
        }
        if (sum.equals(num.substring(k, size + k))) {
            return size + k;
        }

        return -1;
    }

    private String addOnString(String a, String b) {
        return String.valueOf(Long.parseLong(a) + Long.parseLong(b));
    }

//    private String addOnString(String a, String b) {
//        int lenga = a.length();
//        int lengb = b.length();
//        int size = Math.max(lenga, lengb);
//
//        // 进位数字
//        String result = "";
//        int extra = 0;
//        for (int i = 0; i < size; i++) {
//            int inta = 0;
//            if (lenga - 1 - i >= 0) {
//                char chara = a.charAt(lenga - 1 - i);
//                inta = Integer.valueOf(chara + "");
//            }
//
//            int intb = 0;
//            if (lengb - 1 - i >= 0) {
//                char charb = b.charAt(lengb - 1 - i);
//                intb = Integer.valueOf(charb + "");
//            }
//
//            int intResult = inta + intb + extra;
//            extra = intResult / 10;
//            result = (intResult % 10) + result;
//        }
//        if (extra > 0) {
//            result = extra + result;
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("199100199"));
        System.out.println(solution.isAdditiveNumber("199001200"));
        System.out.println(solution.isAdditiveNumber("123"));
        System.out.println(solution.isAdditiveNumber("101"));
        System.out.println(solution.isAdditiveNumber("000"));
    }
}
