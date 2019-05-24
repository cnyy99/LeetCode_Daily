#
# @lc app=leetcode id=228 lang=python3
#
# [228] Summary Ranges
#
# https://leetcode.com/problems/summary-ranges/description/
#
# algorithms
# Medium (35.27%)
# Likes:    360
# Dislikes: 359
# Total Accepted:    130.5K
# Total Submissions: 364K
# Testcase Example:  '[0,1,2,4,5,7]'
#
# Given a sorted integer array without duplicates, return the summary of its
# ranges.
# 
# Example 1:
# 
# 
# Input:  [0,1,2,4,5,7]
# Output: ["0->2","4->5","7"]
# Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
# 
# 
# Example 2:
# 
# 
# Input:  [0,2,3,4,6,8,9]
# Output: ["0","2->4","6","8->9"]
# Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
# 
# 
#
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        length=len(nums)
        i=0
        result=[]
        while i< length:
            pre=nums[i]
            while i+1<length and nums[i]+1==nums[i+1]:
                i+=1
            if pre==nums[i]:
                result.append(str(pre))
            else:
                result.append(str(pre)+'->'+str(nums[i]))
            i+=1
        return result
