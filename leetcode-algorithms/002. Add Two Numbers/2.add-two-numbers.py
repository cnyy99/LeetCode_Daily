#
# @lc app=leetcode id=2 lang=python3
#
# [2] Add Two Numbers
#
# https://leetcode.com/problems/add-two-numbers/description/
#
# algorithms
# Medium (30.66%)
# Likes:    5024
# Dislikes: 1280
# Total Accepted:    848.6K
# Total Submissions: 2.7M
# Testcase Example:  '[2,4,3]\n[5,6,4]'
#
# You are given two non-empty linked lists representing two non-negative
# integers. The digits are stored in reverse order and each of their nodes
# contain a single digit. Add the two numbers and return it as a linked list.
# 
# You may assume the two numbers do not contain any leading zero, except the
# number 0 itself.
# 
# Example:
# 
# 
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8
# Explanation: 342 + 465 = 807.
# 
# 
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1.next == None and l1.val == 0:
            return l2
        if l2.next == None and l2.val == 0:
            return l1
        p1, p2= l1, l2
        sol = ListNode(0)
        head = sol
        head.next = None
        plus,sol.val = (p1.val + p2.val) // 10,(p1.val + p2.val) % 10
        p1,p2 = p1.next, p2.next
        while p1 is not None or p2 is not None:
            temp = ListNode(0)
            val1 = 0 if p1 is None else p1.val
            p1 = p1 if p1 is None else p1.next
            val2 = 0 if p2 is None else p2.val
            p2 = p2 if p2 is None else p2.next
            temp.next,temp.val = None,val1+val2+plus
            plus = temp.val // 10
            temp.val %= 10
            sol.next = temp
            sol = sol.next
        if plus!=0:
            temp = ListNode(0)
            temp.next,temp.val,sol.next = None,1,temp
        return head

