/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.66%)
 * Likes:    5024
 * Dislikes: 1280
 * Total Accepted:    848.6K
 * Total Submissions: 2.7M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 . 4 . 3) + (5 . 6 . 4)
 * Output: 7 . 0 . 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next == null && l1.val == 0)
            return l2;
        if (l2.next == null && l2.val == 0)
            return l1;
        ListNode p1 = l1, p2 = l2;
        ListNode sol = new ListNode(0);
        ListNode head = sol;
        head.next = null;
        int plus = (p1.val + p2.val) / 10;
        sol.val = (p1.val + p2.val) % 10;
        p1 = p1.next;
        p2 = p2.next;
        while (p1 != null || p2 != null) {
            ListNode temp = new ListNode(0);
            int val1, val2;
            val1 = p1 == null ? 0 : p1.val;
            p1 = p1 == null ? p1 : p1.next;
            val2 = p2 == null ? 0 : p2.val;
            p2 = p2 == null ? p2 : p2.next;
            temp.next = null;
            temp.val = val1 + val2 + plus;
            plus = temp.val / 10;
            temp.val %= 10;
            sol.next = temp;
            sol = sol.next;
        }
        if (plus != 0) {
            ListNode temp = new ListNode(0);
            temp.next = null;
            temp.val = 1;
            sol.next = temp;
        }
        return head;
    }
}
