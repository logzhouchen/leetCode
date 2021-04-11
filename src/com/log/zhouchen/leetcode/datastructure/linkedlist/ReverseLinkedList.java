package com.log.zhouchen.leetcode.datastructure.linkedlist;

/**
 * @author: shenzhouchen
 * @date: 2021/4/10 9:59 PM
 **/
public class ReverseLinkedList {

    public Node reverse(Node head) {

        Node pre = null, current = head;
        while (current != null) {
            Node next = current.getNext();

            current.setNext(pre);

            pre = current;
            current = next;
        }

        return pre;
    }

    private void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        Node head = new Node(0, n1);

        ReverseLinkedList solution = new ReverseLinkedList();
        solution.printLinkedList(head);

        Node newHead = solution.reverse(head);
        solution.printLinkedList(newHead);
    }
}
