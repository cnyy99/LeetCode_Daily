#
# @lc app=leetcode id=905 lang=python3
#
# [905] Sort Array By Parity
#
# https://leetcode.com/problems/sort-array-by-parity/description/
#
# algorithms
# Easy (72.13%)
# Total Accepted:    85.5K
# Total Submissions: 118K
# Testcase Example:  '[3,1,2,4]'
#
# Given an array A of non-negative integers, return an array consisting of all
# the even elements of A, followed by all the odd elements of A.
#
# You may return any answer array that satisfies this condition.
#
#
#
#
# Example 1:
#
#
# Input: [3,1,2,4]
# Output: [2,4,3,1]
# The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
#
#
#
#
# Note:
#
#
# 1 <= A.length <= 5000
# 0 <= A[i] <= 5000
#
#
#
#


class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        a = [0]*len(A)
        i = 0
        j = len(A)-1
        for t in A:
            if t % 2 == 0:
                a[i] = t
                i = i+1
            else:
                a[j] = t
                j = j-1
        return a
