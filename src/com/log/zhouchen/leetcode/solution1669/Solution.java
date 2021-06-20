package com.log.zhouchen.leetcode.solution1669;

/**
 * @author: shenzhouchen
 * @date: 2021/6/4 1:13 AM
 **/
public class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;

        ListNode g = dummy, p = list1;
        int index = 0;
        while (index < a) {
            g = p;
            p = p.next;

            index++;
        }
        while (index <= b) {
            p = p.next;
            index++;
        }


        g.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = p;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode n10000 = new ListNode(10000);
        ListNode n10001 = new ListNode(10001);
        ListNode n10002 = new ListNode(10002);
        n10000.next = n10001;
        n10001.next = n10002;

        Solution solution = new Solution();
        ListNode newHead = solution.mergeInBetween(n0,3, 4, n10000);
        for (; newHead != null; newHead = newHead.next) {
            System.out.println(newHead.val);
        }
    }
}
