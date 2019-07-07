#
# @lc app=leetcode id=387 lang=python3
#
# [387] First Unique Character in a String
#
# https://leetcode.com/problems/first-unique-character-in-a-string/description/
#
# algorithms
# Easy (50.17%)
# Likes:    1055
# Dislikes: 80
# Total Accepted:    283.3K
# Total Submissions: 563.2K
# Testcase Example:  '"leetcode"'
#
#
# Given a string, find the first non-repeating character in it and return it's
# index. If it doesn't exist, return -1.
#
# Examples:
#
# s = "leetcode"
# return 0.
#
# s = "loveleetcode",
# return 2.
#
#
#
#
# Note: You may assume the string contain only lowercase letters.
#
#


class Solution:
    def firstUniqChar(self, s: str) -> int:
        # result = [0]*26
        # for t in s:
        #     result[ord(t)-ord('a')]+=1
        # for i in range(len(s)):
        #     if result[ord(s[i])-ord('a')]==1:
        #         return i
        # return -1
        return min([s.index(l) for l in string.ascii_lowercase if s.count(l) == 1] or [-1])
