package com.log.zhouchen.leetcode.solution707;

/**
 * @author: shenzhouchen
 * @date: 2021/6/4 10:46 PM
 **/
class MyLinkedList {

    private Node first;

    private Node last;

    /** 链表长度 **/
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node targetNode = getNode(index);
        if (targetNode == null) {
            return -1;
        }

        return targetNode.item;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        if (index <= size >> 1) {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;

        } else {
            Node current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(null, val, first);
        if (first == null) {
            // 原先为空
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(last, val, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }

        Node oldNode = getNode(index);
        if (oldNode == null) {
            return;
        }

        Node newNode = new Node(oldNode.prev, val, oldNode);

        oldNode.prev.next = newNode;
        oldNode.prev = newNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node oldNode = getNode(index);
        if (oldNode == null) {
            return;
        }

        Node pre = oldNode.prev;
        Node succ = oldNode.next;

        if (pre == null) {
            first = succ;
        } else {
            pre.next = succ;
        }

        if (succ == null) {
            last = pre;
        } else {
            succ.prev = pre;
        }

        size--;
    }

    private static class Node {
        int item;
        Node next;
        Node prev;

        Node(Node prev, int element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.printLinkedList();

        linkedList.addAtHead(2);
        linkedList.printLinkedList();

        linkedList.addAtHead(1);
        linkedList.printLinkedList();

        linkedList.addAtIndex(3, 0);
        linkedList.printLinkedList();

        linkedList.deleteAtIndex(2);
        linkedList.printLinkedList();

        linkedList.addAtHead(6);
        linkedList.printLinkedList();

        linkedList.addAtTail(4);
        linkedList.printLinkedList();

        System.out.println(linkedList.get(4));

        linkedList.addAtHead(4);
        linkedList.printLinkedList();

        linkedList.addAtIndex(5, 0);
        linkedList.printLinkedList();

        linkedList.addAtHead(6);
        linkedList.printLinkedList();
    }

    private void printLinkedList() {
        Node current = first;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */