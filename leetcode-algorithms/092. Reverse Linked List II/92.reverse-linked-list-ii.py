#
# @lc app=leetcode id=92 lang=python3
#
# [92] Reverse Linked List II
#
# https://leetcode.com/problems/reverse-linked-list-ii/description/
#
# algorithms
# Medium (35.73%)
# Likes:    1385
# Dislikes: 97
# Total Accepted:    209.2K
# Total Submissions: 584.7K
# Testcase Example:  '[1,2,3,4,5]\n2\n4'
#
# Reverse a linked list from position m to n. Do it in one-pass.
#
# Note: 1 ≤ m ≤ n ≤ length of list.
#
# Example:
#
#
# Input: 1->2->3->4->5->NULL, m = 2, n = 4
# Output: 1->4->3->2->5->NULL
#
#
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        newHead = ListNode(-1)
        newHead.next, pre = head, newHead
        for _ in range(m-1):
            pre = pre.next
        cur = pre.next
        for _ in range(n-m):
            pre.next, cur.next, pre.next.next = \
                cur.next, cur.next.next, pre.next
        return newHead.next
