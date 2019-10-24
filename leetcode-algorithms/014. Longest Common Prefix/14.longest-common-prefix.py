#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#
# https://leetcode.com/problems/longest-common-prefix/description/
#
# algorithms
# Easy (33.98%)
# Likes:    1588
# Dislikes: 1451
# Total Accepted:    534.7K
# Total Submissions: 1.6M
# Testcase Example:  '["flower","flow","flight"]'
#
# Write a function to find the longest common prefix string amongst an array of
# strings.
#
# If there is no common prefix, return an empty string "".
#
# Example 1:
#
#
# Input: ["flower","flow","flight"]
# Output: "fl"
#
#
# Example 2:
#
#
# Input: ["dog","racecar","car"]
# Output: ""
# Explanation: There is no common prefix among the input strings.
#
#
# Note:
#
# All given inputs are in lowercase letters a-z.
#
#


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""

        def find(left, right):
            size, i = min(len(left), len(right)),  0
            for _ in range(size):
                if left[i] != right[i]:
                    break
                i += 1
            return left[:i]
        res = strs[0]
        for str in strs:
            res = find(res, str)
            if not res:
                break
        return res
