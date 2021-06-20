package com.log.zhouchen.leetcode.solution92;

/**
 * @author: shenzhouchen
 * @date: 2021/6/3 1:02 AM
 **/
public class Solution {

//
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (left == right || head == null) {
//            return head;
//        }
//
//        ListNode dummy = new ListNode();
//        dummy.next = reverse(head, 1, left, right);
//
//        return dummy.next;
//    }
//
//    private ListNode reverse(ListNode node, int index, int left, int right) {
//        if (index < left) {
//            node.next = reverse(node.next, index + 1, left, right);
//            return node;
//        }
//
//        // index == left
//        ListNode current = node, pre = null;
//        while (index <= right) {
//            ListNode next = current.next;
//
//            current.next = pre;
//            pre = current;
//            current = next;
//            index++;
//        }
//
//        node.next = current;
//        return pre;
//    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        int index = 1;
        ListNode g = dummy, p = head;
        while (index < left) {
            g = p;
            p = p.next;

            index++;
        }
        while (index < right) {
            ListNode temp = p.next;
            p.next = p.next.next;

            temp.next = g.next;
            g.next = temp;

            index++;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution solution = new Solution();
        ListNode newHead = solution.reverseBetween(n1,2, 4);
        for (; newHead != null; newHead = newHead.next) {
            System.out.println(newHead.val);
        }
    }
}
