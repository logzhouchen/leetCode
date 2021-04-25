package com.log.zhouchen.leetcode.java.thread;

/**
 * @author: shenzhouchen
 * @date: 2021/4/18 4:18 PM
 *
 *
 * No block, query without stop
 **/
public class LoopPrintABCInOrder1 {

    private volatile String flag;

    public class MyRunnable implements Runnable {

        private String nowToPrint;
        private String nextToPrint;

        public MyRunnable(String printString, String next) {
            super();
            this.nowToPrint = printString;
            this.nextToPrint = next;
        }

        @Override
        public void run() {
            while(true) {
                if (nowToPrint.equals(flag)) {
                    System.out.println(nowToPrint);
                    setFlag(nextToPrint);
                }
            }
        }
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        LoopPrintABCInOrder1 solution = new LoopPrintABCInOrder1();
        solution.setFlag("A");

        Thread a = new Thread(solution.new MyRunnable("A", "B"));
        Thread b = new Thread(solution.new MyRunnable("B", "C"));
        Thread c = new Thread(solution.new MyRunnable("C", "A"));
        a.start();
        b.start();
        c.start();
    }
}
