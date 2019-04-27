#
# @lc app=leetcode id=977 lang=python3
#
# [977] Squares of a Sorted Array
#
# https://leetcode.com/problems/squares-of-a-sorted-array/description/
#
# algorithms
# Easy (72.86%)
# Total Accepted:    56.2K
# Total Submissions: 77.7K
# Testcase Example:  '[-4,-1,0,3,10]'
#
# Given an array of integers A sorted in non-decreasing order, return an array
# of the squares of each number, also in sorted non-decreasing order.
# 
# 
# 
# 
# Example 1:
# 
# 
# Input: [-4,-1,0,3,10]
# Output: [0,1,9,16,100]
# 
# 
# 
# Example 2:
# 
# 
# Input: [-7,-3,2,3,11]
# Output: [4,9,9,49,121]
# 
# 
# 
# 
# Note:
# 
# 
# 1 <= A.length <= 10000
# -10000 <= A[i] <= 10000
# A is sorted in non-decreasing order.
# 
# 
# 
#
class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        # left,right=0,len(A)-1
        # sol=[_ for _ in range(len(A))]
        # for i in range(len(A)-1,-1,-1):
        #     if abs(A[left])>abs(A[right]):
        #         sol[i]=A[left]*A[left]
        #         left+=1
        #     else:
        #         sol[i]=A[right]*A[right]
        #         right-=1
        # return sol
        return sorted(x*x for x in A)

