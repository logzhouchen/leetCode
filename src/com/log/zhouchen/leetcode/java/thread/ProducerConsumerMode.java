package com.log.zhouchen.leetcode.java.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: shenzhouchen
 * @date: 2021/4/16 12:12 AM
 **/
public class ProducerConsumerMode {


    public static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_SIZE) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                        }
                    }

                    queue.offer(new Object());
                    System.out.println("produce");

                    queue.notifyAll();
                }

            }
        }
    }

    public static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                        }
                    }

                    queue.poll();
                    System.out.println("consume");

                    queue.notifyAll();
                }
            }
        }
    }

    private static Queue<Object> queue = new LinkedList<>();
    private static final int MAX_SIZE = 2;

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.start();

        Producer producer = new Producer();
        producer.start();
    }
}
