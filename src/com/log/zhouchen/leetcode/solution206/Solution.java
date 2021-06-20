package com.log.zhouchen.leetcode.solution206;

/**
 * @author: shenzhouchen
 * @date: 2021/6/3 12:56 AM
 **/
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head;

        while (current != null) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
