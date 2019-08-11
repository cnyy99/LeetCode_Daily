#
# @lc app=leetcode id=442 lang=python3
#
# [442] Find All Duplicates in an Array
#
# https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
#
# algorithms
# Medium (60.03%)
# Total Accepted:    94.5K
# Total Submissions: 156K
# Testcase Example:  '[4,3,2,7,8,2,3,1]'
#
# Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
# appear twice and others appear once.
#
# Find all the elements that appear twice in this array.
#
# Could you do it without extra space and in O(n) runtime?
#
# Example:
#
# Input:
# [4,3,2,7,8,2,3,1]
#
# Output:
# [2,3]
#
#


class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        list = []
        for i in range(len(nums)):
            if nums[abs(nums[i])-1] > 0:
                nums[abs(nums[i])-1] *= -1
            else:
                list.append(abs(nums[i]))
        return list
        # n = set(nums)
        # res = []
        # for i in nums:
        #     if i in n:
        #         n.remove(i)
        #     else:
        #         res.append(i)
        # return res
