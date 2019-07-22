#
# @lc app=leetcode id=912 lang=python3
#
# [912] Sort an Array
#
# https://leetcode.com/problems/sort-an-array/description/
#
# algorithms
# Medium (63.48%)
# Likes:    58
# Dislikes: 78
# Total Accepted:    10.6K
# Total Submissions: 16.7K
# Testcase Example:  '[5,2,3,1]'
#
# Given an array of integers nums, sort the array in ascending order.
#
#
#
#
#
#
# Example 1:
#
#
# Input: [5,2,3,1]
# Output: [1,2,3,5]
#
#
# Example 2:
#
#
# Input: [5,1,1,2,0,0]
# Output: [0,0,1,1,2,5]
#
#
#
#
# Note:
#
#
# 1 <= A.length <= 10000
# -50000 <= A[i] <= 50000
#
#
#


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.qsort(nums, 0, len(nums)-1)
        # nums = sorted(nums)
        return nums

    def qsort(self, nums, low, high):
        def partition(nums, low, high):
            i = low - 1
            pivot = nums[high]
            for j in range(low, high):
                if nums[j] <= pivot:
                    i = i + 1
                    nums[i], nums[j] = nums[j], nums[i]
            nums[i+1], nums[high] = nums[high], nums[i+1]
            return i + 1

        if low < high:
            pi = partition(nums, low, high)
            self.qsort(nums, low, pi-1)
            self.qsort(nums, pi+1, high)
