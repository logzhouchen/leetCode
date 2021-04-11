package com.log.zhouchen.leetcode.datastructure.linkedlist;

/**
 * @author: shenzhouchen
 * @date: 2021/4/10 10:02 PM
 **/
public class Node {

    private int value;

    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
