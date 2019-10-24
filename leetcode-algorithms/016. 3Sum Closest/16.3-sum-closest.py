#
# @lc app=leetcode id=16 lang=python3
#
# [16] 3Sum Closest
#
# https://leetcode.com/problems/3sum-closest/description/
#
# algorithms
# Medium (41.16%)
# Total Accepted:    329.7K
# Total Submissions: 739.4K
# Testcase Example:  '[-1,2,1,-4]\n1'
#
# Given an array nums of n integers and an integer target, find three integers
# in nums such that the sum is closest to target. Return the sum of the three
# integers. You may assume that each input would have exactly one solution.
#
# Example:
#
#
# Given array nums = [-1, 2, 1, -4], and target = 1.
#
# The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
#
#
#


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        closest, this_len, sol, nums = 9999999999999999999999999999, 0, 0, sorted(
            nums)
        for i in range(len(nums)):
            left, right = i + 1, len(nums) - 1
            while left < right:
                this_sum = nums[i] + nums[left] + nums[right]
                this_len = abs(this_sum - target)
                if this_sum == target:
                    return this_sum
                if this_len < closest:
                    closest, sol = this_len, this_sum
                if this_sum > target:
                    right -= 1
                else:
                    left += 1
        return sol
