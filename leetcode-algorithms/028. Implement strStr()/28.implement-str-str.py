#
# @lc app=leetcode id=28 lang=python3
#
# [28] Implement strStr()
#
# https://leetcode.com/problems/implement-strstr/description/
#
# algorithms
# Easy (31.30%)
# Likes:    839
# Dislikes: 1261
# Total Accepted:    415.4K
# Total Submissions: 1.3M
# Testcase Example:  '"hello"\n"ll"'
#
# Implement strStr().
# 
# Return the index of the first occurrence of needle in haystack, or -1 if
# needle is not part of haystack.
# 
# Example 1:
# 
# 
# Input: haystack = "hello", needle = "ll"
# Output: 2
# 
# 
# Example 2:
# 
# 
# Input: haystack = "aaaaa", needle = "bba"
# Output: -1
# 
# 
# Clarification:
# 
# What should we return when needle is an empty string? This is a great
# question to ask during an interview.
# 
# For the purpose of this problem, we will return 0 when needle is an empty
# string. This is consistent to C's strstr() and Java's indexOf().
# 
#
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0
        if len(needle)>len(haystack):
            return -1
        bc=[0 for _ in range(256)]
        def getbc(pattern):
            patternLen = len(pattern)
            for i in range(256):
                bc[i] = -1
            i=0
            for i in range(patternLen):
                bc[ord(pattern[i])] = i
            return bc
        abc = getbc(needle)
        global i
        global j
        i,j=0,0
        patternlast,patternLen,strLen = len(needle) - 1, len(needle), len(haystack)
        while i + patternLen <= strLen:
            for j in range(patternlast,-2,-1):
                if j!=-1 and needle[j] != haystack[i + j]:
                    break
            if j == -1:
                break
            else:
                span = j - abc[ord(haystack[i + j])]
                i +=span if span > 0 else 1
        return i if j == -1 else -1

