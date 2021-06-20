package com.log.zhouchen.leetcode.solution295;

import java.util.PriorityQueue;

/**
 * @author: shenzhouchen
 * @date: 2021/6/17 10:57 PM
 **/
public class MedianFinder {

    PriorityQueue<Integer> big = new PriorityQueue<>((o1, o2) -> o2 - o1);

    PriorityQueue<Integer> small = new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (big.isEmpty()) {
            big.add(num);
            return;
        }

        if (big.size() == small.size()) {
            if (num <= big.peek()) {
                big.add(num);
            } else {
                small.add(num);
            }
        } else if (big.size() > small.size()) {
            if (num <= big.peek()) {
                small.add(big.poll());
                big.add(num);
            } else {
                small.add(num);
            }
        } else {
            if (num <= big.peek()) {
                big.add(num);
            } else {
                small.add(num);
                big.add(small.poll());
            }
        }
    }

    public double findMedian() {
        if (big.size() == small.size()) {
            if (big.size() == 0) {
                return 0;
            } else {
                return ((double) (big.peek()) + small.peek()) / 2;
            }
        } else {
            PriorityQueue<Integer> hasMoreElements = big.size() > small.size() ? big : small;
            return hasMoreElements.peek();
        }
    }


    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();

        solution.addNum(12);
        solution.addNum(10);
        solution.addNum(13);
        solution.addNum(11);
        solution.addNum(5);
        System.out.println(solution.findMedian());
    }
}
