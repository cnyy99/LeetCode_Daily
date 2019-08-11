#
# @lc app=leetcode id=628 lang=python3
#
# [628] Maximum Product of Three Numbers
#
# https://leetcode.com/problems/maximum-product-of-three-numbers/description/
#
# algorithms
# Easy (45.61%)
# Total Accepted:    66.3K
# Total Submissions: 144.7K
# Testcase Example:  '[1,2,3]'
#
# Given an integer array, find three numbers whose product is maximum and
# output the maximum product.
#
# Example 1:
#
#
# Input: [1,2,3]
# Output: 6
#
#
#
#
# Example 2:
#
#
# Input: [1,2,3,4]
# Output: 24
#
#
#
#
# Note:
#
#
# The length of the given array will be in range [3,10^4] and all elements are
# in the range [-1000, 1000].
# Multiplication of any three numbers in the input won't exceed the range of
# 32-bit signed integer.
#
#
#
#
#


class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        # min1=999999999
        # min2=999999999
        # max1=-99999999
        # max2=-99999999
        # max3=-99999999
        # for i in range(len(nums)):
        #     if nums[i]<=min1:
        #         min2=min1
        #         min1=nums[i]
        #     elif nums[i]<=min2:
        #         min2=nums[i]
        #     if nums[i]>=max1:
        #         max3=max2
        #         max2=max1
        #         max1=nums[i]
        #     elif nums[i]>=max2:
        #         max3=max2
        #         max2=nums[i]
        #     elif nums[i]>=max3:
        #         max3=nums[i]
        # maxs=max(max1*min1*min2,max1*max2*max3)
        # return maxs
        a, b, c = heapq.nlargest(3, nums)
        d, e = heapq.nsmallest(2, nums)
        return max(a * b * c, d * e * a)
