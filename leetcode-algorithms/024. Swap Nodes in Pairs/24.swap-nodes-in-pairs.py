#
# @lc app=leetcode id=24 lang=python3
#
# [24] Swap Nodes in Pairs
#
# https://leetcode.com/problems/swap-nodes-in-pairs/description/
#
# algorithms
# Medium (44.99%)
# Likes:    1303
# Dislikes: 115
# Total Accepted:    341.3K
# Total Submissions: 745.3K
# Testcase Example:  '[1,2,3,4]'
#
# Given a linked list, swap every two adjacent nodes and return its head.
#
# You may not modify the values in the list's nodes, only nodes itself may be
# changed.
#
#
#
# Example:
#
#
# Given 1.2.3.4, you should return the list as 2.1.4.3.
#
#
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        def swapNode(p, q, r):
            q.next = r.next
            r.next = q
            p.next = r
        if not head:
            return head
        newHead = ListNode(-1)
        newHead.next = head
        p, q, r = newHead, head, head.next
        while r:
            swapNode(p, q, r)
            r, q = q, r
            p = p.next.next
            q = q.next.next
            if not r.next:
                break
            r = r.next.next
        return newHead.next
