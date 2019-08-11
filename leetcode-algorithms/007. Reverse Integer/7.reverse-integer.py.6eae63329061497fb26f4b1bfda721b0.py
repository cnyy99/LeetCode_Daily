#
# @lc app=leetcode id=7 lang=python3
#
# [7] Reverse Integer
#
# https://leetcode.com/problems/reverse-integer/description/
#
# algorithms
# Easy (25.17%)
# Total Accepted:    651.5K
# Total Submissions: 2.6M
# Testcase Example:  '123'
#
# Given a 32-bit signed integer, reverse digits of an integer.
#
# Example 1:
#
#
# Input: 123
# Output: 321
#
#
# Example 2:
#
#
# Input: -123
# Output: -321
#
#
# Example 3:
#
#
# Input: 120
# Output: 21
#
#
# Note:
# Assume we are dealing with an environment which could only store integers
# within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
# of this problem, assume that your function returns 0 when the reversed
# integer overflows.
#
#


class Solution:
    def reverse(self, x: int) -> int:
        t = True
        INT_MAX = 2147483647
        INT_MIN = -INT_MAX - 1
        if x < 0:
            x = -x
            t = False
        n = 0
        if 0 <= x and x < 10:
            if t:
                return x
            else:
                return -x
        old = 0
        while x > 0:
            old = n
            n = x % 10+(n*10)
            if n > INT_MAX and t:
                return 0
            if -n < INT_MIN and not t:
                return 0
            x = x//10
        if t:
            return n
        else:
            return -n
