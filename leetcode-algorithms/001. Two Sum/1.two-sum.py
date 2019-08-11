#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#
# https://leetcode.com/problems/two-sum/description/
#
# algorithms
# Easy (42.22%)
# Total Accepted:    1.6M
# Total Submissions: 3.7M
# Testcase Example:  '[2,7,11,15]\n9'
#
# Given an array of integers, return indices of the two numbers such that they
# add up to a specific target.
#
# You may assume that each input would have exactly one solution, and you may
# not use the same element twice.
#
# Example:
#
#
# Given nums = [2, 7, 11, 15], target = 9,
#
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].
#
#
#
#
#


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        a = dict()
        sol = [0, 0]
        for i in range(0, len(nums)):
            if target-nums[i] in a:
                sol[0] = a[target-nums[i]]
                sol[1] = i
            a[nums[i]] = i
        return sol
