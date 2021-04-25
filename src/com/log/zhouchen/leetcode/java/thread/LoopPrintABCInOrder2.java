package com.log.zhouchen.leetcode.java.thread;

/**
 * @author: shenzhouchen
 * @date: 2021/4/18 4:18 PM
 *
 **/
public class LoopPrintABCInOrder2 {

    private volatile String flag;
    private volatile Object object = new Object();

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
                synchronized (object) {
                    while (!nowToPrint.equals(flag)) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                        }
                    }

                    System.out.println(nowToPrint);
                    setFlag(nextToPrint);
                    object.notifyAll();
                }
            }
        }
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        LoopPrintABCInOrder2 solution = new LoopPrintABCInOrder2();
        solution.setFlag("A");

        Thread a = new Thread(solution.new MyRunnable("A", "B"));
        Thread b = new Thread(solution.new MyRunnable("B", "C"));
        Thread c = new Thread(solution.new MyRunnable("C", "A"));
        a.start();
        b.start();
        c.start();
    }
}
