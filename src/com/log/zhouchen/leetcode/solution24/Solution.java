package com.log.zhouchen.leetcode.solution24;

/**
 * @author: shenzhouchen
 * @date: 2021/3/30 12:49 AM
 **/
public class Solution {
    /**
     * 题解，俩俩交换
     */
    public ListNode swapPairs(ListNode head) {
        ListNode current = head;

        ListNode result = null, last = null;
        while (current != null && current.next != null) {
            // 3指针
            ListNode former = current;
            ListNode later = current.next;
            ListNode temp = later.next;

            // 交换相邻节点
            later.next = former;
            former.next = temp;
            if (last != null) {
                last.next = later;
            }

            if (result == null) {
                result = later;
            }
            current = temp;
            last = former;
        }

        if (result == null) {
            result = head;
        }
        return result;
    }

    /**
     * 链表翻转
     */
    public ListNode reverseListNode2(ListNode head) {
        ListNode pre = null, current = head;

        while (current != null) {
            ListNode next = current.next;

            current.next = pre;

            pre = current;
            current = next;
        }

        return pre;
    }


    private void printNodeList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        Solution solution = new Solution();
        solution.printNodeList(one);

        solution.printNodeList(solution.reverseListNode2(one));
    }
}
