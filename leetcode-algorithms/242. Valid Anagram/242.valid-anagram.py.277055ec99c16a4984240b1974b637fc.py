#
# @lc app=leetcode id=242 lang=python3
#
# [242] Valid Anagram
#
# https://leetcode.com/problems/valid-anagram/description/
#
# algorithms
# Easy (52.42%)
# Likes:    747
# Dislikes: 111
# Total Accepted:    356.2K
# Total Submissions: 676.9K
# Testcase Example:  '"anagram"\n"nagaram"'
#
# Given two strings s and t , write a function to determine if t is an anagram
# of s.
#
# Example 1:
#
#
# Input: s = "anagram", t = "nagaram"
# Output: true
#
#
# Example 2:
#
#
# Input: s = "rat", t = "car"
# Output: false
#
#
# Note:
# You may assume the string contains only lowercase alphabets.
#
# Follow up:
# What if the inputs contain unicode characters? How would you adapt your
# solution to such case?
#
#


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # solution 1
        # if len(s)!=len(t):
        #     return False
        # map=[0]*26
        # for i in range(len(s)):
        #     map[ord(s[i]) - ord('a')]+=1
        #     map[ord(t[i]) - ord('a')]-=1
        # for c in map:
        #     if c:
        #         return False
        # return True
        #
        # solution 2
        # return sorted(s)==sorted(t)
        #
        # solution 3
        return collections.Counter(s) == collections.Counter(t)
