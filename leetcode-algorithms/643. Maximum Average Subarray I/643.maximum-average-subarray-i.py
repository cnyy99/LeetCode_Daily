#
# @lc app=leetcode id=643 lang=python3
#
# [643] Maximum Average Subarray I
#
# https://leetcode.com/problems/maximum-average-subarray-i/description/
#
# algorithms
# Easy (39.06%)
# Total Accepted:    49.2K
# Total Submissions: 125.2K
# Testcase Example:  '[1,12,-5,-6,50,3]\n4'
#
# Given an array consisting of n integers, find the contiguous subarray of
# given length k that has the maximum average value. And you need to output the
# maximum average value.
#
# Example 1:
#
#
# Input: [1,12,-5,-6,50,3], k = 4
# Output: 12.75
# Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
#
#
#
#
# Note:
#
#
# 1 <= k <= n <= 30,000.
# Elements of the given array will be in the range [-10,000, 10,000].
#
#
#
#
#


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        maxsum = mysum = sum(nums[:k])
        for i in range(k, len(nums)):
            mysum = mysum-nums[i-k]+nums[i]
            maxsum = max(maxsum, mysum)
        return maxsum*1.0/k
