/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (41.95%)
 * Likes:    774
 * Dislikes: 82
 * Total Accepted:    333.1K
 * Total Submissions: 779.9K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * 
 * Input: 1.1.2
 * Output: 1.2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1.1.2.3.3
 * Output: 1.2.3
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p.next;
        while (q != null) {
            if (p.val == q.val) {
                p.next = q.next;
                q = q.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
