package com.log.zhouchen.leetcode.solution43;

/**
 * @author: shenzhouchen
 * @date: 2021/4/21 9:46 PM
 **/
public class NewSolution {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length(), n = num2.length(), len = m + n;
        int[] res = new int[len];

        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int sum = a * b + res[i + j + 1];

                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
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

    public static void main(String[] args) {
        NewSolution solution = new NewSolution();
        System.out.println(solution.multiply("123", "10"));
    }
}
