package com.log.zhouchen.leetcode.java.thread;

/**
 * @author: shenzhouchen
 * @date: 2021/4/18 4:39 PM
 **/
public class OneTimePrintABCInOrder {

    public class MyRunnable implements Runnable {

        private String nowToPrint;

        private Thread dependOnThread;

        public MyRunnable(String now, Thread dependOn) {
            this.nowToPrint = now;
            this.dependOnThread = dependOn;
        }

        @Override
        public void run() {
            if (dependOnThread != null) {
                try {
                    dependOnThread.join();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException error");
                }
            }
            System.out.println(nowToPrint);
        }
    }

    public static void main(String[] args) {
        OneTimePrintABCInOrder solution = new OneTimePrintABCInOrder();
        Thread a = new Thread(solution.new MyRunnable("A", null));
        Thread b = new Thread(solution.new MyRunnable("B", a));
        Thread c = new Thread(solution.new MyRunnable("C", b));

        c.start();
        b.start();
        a.start();
    }
}
