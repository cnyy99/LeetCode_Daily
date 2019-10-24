#
# @lc app=leetcode id=697 lang=python3
#
# [697] Degree of an Array
#
# https://leetcode.com/problems/degree-of-an-array/description/
#
# algorithms
# Easy (49.35%)
# Total Accepted:    46.4K
# Total Submissions: 92.9K
# Testcase Example:  '[1,2,2,3,1]'
#
#   Given a non-empty array of non-negative integers   nums  , the
#   degree   of this array is defined as the maximum frequency of any one of
# its elements.
#   Your task is to find the smallest possible length of a (contiguous)
# subarray of   nums  , that has the same degree as
#   nums  .
#
#     Example 1:
#
#   Input:   [1, 2, 2, 3, 1]
#   Output:   2
#   Explanation:
# The input array has a degree of 2 because both elements 1 and 2 appear twice.
# Of the subarrays that have the same degree:
# [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
# The shortest length is 2. So return 2.
#
#
#
#
#     Example 2:
#
#   Input:   [1,2,2,3,1,4,2]
#   Output:   6
#
#
#
#     Note:
#     nums.length   will be between 1 and 50,000.
#     nums[i]   will be an integer between 0 and 49,999.
#
#


class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        sol = {}
        begin = {}
        end = {}
        it = 0
        max1 = 0
        for t in nums:
            if t not in sol:
                sol[t] = 1
            else:
                sol[t] += 1
            max1 = max1 if max1 > sol[t] else sol[t]
            if t not in begin:
                begin[t] = it
            end[t] = it
            it += 1
        soultion = 9999999999999
        for first, second in sol.items():
            if second == max1:
                dis = end[first]-begin[first]+1
                soultion = soultion if soultion < dis else dis
        return soultion
