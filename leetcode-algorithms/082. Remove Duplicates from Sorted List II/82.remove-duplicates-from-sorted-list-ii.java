/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.25%)
 * Likes:    843
 * Dislikes: 72
 * Total Accepted:    184.7K
 * Total Submissions: 556.4K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1.2.3.3.4.4.5
 * Output: 1.2.5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1.1.1.2.3
 * Output: 2.3
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode phead = new ListNode(-1);
        phead.next = head;
        ListNode p = phead;
        ListNode q = head;
        while (q != null) {
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }
            if (p.next == q) {
                p = q;
            } else {
                p.next = q.next;
            }
            q = q.next;
        }
        return phead.next;
    }
}
