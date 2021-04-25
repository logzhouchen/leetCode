package com.log.zhouchen.leetcode.solution43;

/**
 * @author: shenzhouchen
 * @date: 2021/4/13 12:21 AM
 **/
public class OldSolution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length(), len2 = num2.length(), len = len1 + len2;
        int[] res = new int[len];

        for (int i = len2 - 1; i >= 0; i--) {
            int[] temp = multiply(num1, num2.charAt(i));

            // 末尾补0
            int[] newTemp = new int[len2 - 1 - i + temp.length];
            System.arraycopy(temp, 0, newTemp, 0, temp.length);

            add(res, newTemp);
        }


        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int num : res) {
            if (num == 0 && !start) {
                continue;
            }

            start = true;
            sb.append(num);
        }

        return sb.toString();
    }

    private int[] multiply(String num, char ch) {
        int[] res = new int[num.length() + 1];

        int multiplier = ch - '0', extra = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int int1 = num.charAt(i) - '0';

            int sum = int1 * multiplier + extra;
            extra = sum / 10;
            res[i + 1] = sum % 10;
        }

        res[0] = extra;

        return res;
    }


    private void add(int[] res, int[] temp) {
        int extra = 0;
        for (int i = 0; i < res.length; i++) {
            int a = res[res.length - 1 - i];
            int b = i >= temp.length ? 0 : temp[temp.length - 1 - i];

            int sum = a + b + extra;
            extra = sum / 10;
            res[res.length - 1 - i] = sum % 10;
        }
        if (extra > 0) {
            res[0] = extra;
        }
    }


    public static void main(String[] args) {
        OldSolution oldSolution = new OldSolution();
        System.out.println(oldSolution.multiply("9", "9"));
    }
}
