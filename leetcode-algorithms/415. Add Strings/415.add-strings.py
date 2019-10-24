#
# @lc app=leetcode id=415 lang=python3
#
# [415] Add Strings
#
# https://leetcode.com/problems/add-strings/description/
#
# algorithms
# Easy (44.31%)
# Likes:    468
# Dislikes: 158
# Total Accepted:    108.4K
# Total Submissions: 244.7K
# Testcase Example:  '"0"\n"0"'
#
# Given two non-negative integers num1 and num2 represented as string, return
# the sum of num1 and num2.
#
# Note:
#
# The length of both num1 and num2 is < 5100.
# Both num1 and num2 contains only digits 0-9.
# Both num1 and num2 does not contain any leading zero.
# You must not use any built-in BigInteger library or convert the inputs to
# integer directly.
#
#
#


class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        if len(num1) < len(num2):
            return self.addStrings(num2, num1)
        res, plus, i, j = ['0'] * len(num1), 0, len(num1) - 1, len(num2) - 1
        while j >= 0:
            temp = int(num1[i]) + int(num2[j]) + plus
            res[i] = str(temp % 10)
            plus = temp // 10
            i -= 1
            j -= 1
        while i >= 0:
            res[i] = str((int(num1[i]) + plus) % 10)
            plus = (int(num1[i]) + plus) // 10
            i -= 1
        if plus:
            return '1' + ''.join(res)
        return ''.join(res)
