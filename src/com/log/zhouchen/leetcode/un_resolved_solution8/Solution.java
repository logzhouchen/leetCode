package com.log.zhouchen.leetcode.un_resolved_solution8;

/**
 * @author: shenzhouchen
 * @date: 2021/3/28 2:04 PM
 **/
public class Solution {

    public static final String POS_MAX = "2147483647";
    public static final String NEG_MAX = "2147483648";

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();

        boolean start = false;
        int negativePositive = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (!start) {
                if (ch == ' ') {
                    continue;
                }
                if (ch == '+' && negativePositive == 0) {
                    negativePositive = 1;
                    continue;
                }
                if (ch == '-' && negativePositive == 0) {
                    negativePositive = -1;
                    continue;
                }

                if (isDigital(ch)) {
                    if (negativePositive == 0) {
                        negativePositive = 1;
                    }

                    if (ch == '0') {
                    } else {
                        start = true;
                        sb.append(ch);
                    }
                    continue;
                }

                break;
            } else {
                if (isDigital(ch)) {
                    sb.append(ch);

                    int checkResult = checkOutOfRange(sb, negativePositive);
                    if (checkResult >= 0) {
                        return negativePositive > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
        }

        if (negativePositive < 0 && sb.length() > 0) {
            sb.insert(0, "-");
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return Integer.valueOf(sb.toString());
    }


    private boolean isDigital(char ch) {
        return ch >= '0' && ch <= '9';
    }


    private int checkOutOfRange(StringBuilder sb, int negativePositive) {
        String compare = negativePositive > 0 ? POS_MAX : NEG_MAX;

        if (sb.length() < compare.length()) {
            return -1;
        }
        if (sb.length() > compare.length()) {
            return 1;
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == compare.charAt(i)) {
                continue;
            } else {
                return sb.charAt(i) - compare.charAt(i);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myAtoi("+1"));
        System.out.println(solution.myAtoi("+-12"));
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("     -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("-2147483648"));
        System.out.println(solution.myAtoi("91283472332"));
        System.out.println(solution.myAtoi("21474836460"));
        System.out.println(solution.myAtoi("2147483647"));
    }
}
