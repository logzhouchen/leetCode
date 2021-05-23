package com.log.zhouchen.leetcode.interview.bilibili;

import java.util.Stack;

/**
 * @author: shenzhouchen
 * @date: 2021/5/3 8:44 AM
 **/
public class Ten2Binary {

    private String ten2Binary2(int num) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 32; i++) {
            stack.push((num >> i) & 1);
        }

        return composeToString(stack);
    }

    /**
     * 只能处理非负数
     */
    private String ten2Binary1(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % 2);
            num = num / 2;
        }

        return composeToString(stack);
    }

    private String composeToString(Stack<Integer> stack) {
        boolean meetFirstNonzero = false;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Integer item = stack.pop();
            if (!meetFirstNonzero) {
                if (item == 0) {
                    continue;
                } else {
                    meetFirstNonzero = true;
                }
            }

            sb.append(item);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Ten2Binary solution = new Ten2Binary();

        Integer integer = Integer.valueOf(0);
        System.out.println(solution.ten2Binary2(integer));
        System.out.println(solution.ten2Binary2(integer).equals(Integer.toBinaryString(integer)));

        integer = Integer.valueOf(11);
        System.out.println(solution.ten2Binary2(integer));
        System.out.println(solution.ten2Binary2(integer).equals(Integer.toBinaryString(integer)));

        integer = Integer.MAX_VALUE;
        System.out.println(solution.ten2Binary2(integer));
        System.out.println(solution.ten2Binary2(integer).equals(Integer.toBinaryString(integer)));

        integer = Integer.valueOf(-11);
        System.out.println(solution.ten2Binary2(integer));
        System.out.println(solution.ten2Binary2(integer).equals(Integer.toBinaryString(integer)));

        integer = Integer.MIN_VALUE;
        System.out.println(solution.ten2Binary2(integer));
        System.out.println(solution.ten2Binary2(integer).equals(Integer.toBinaryString(integer)));
    }
}
