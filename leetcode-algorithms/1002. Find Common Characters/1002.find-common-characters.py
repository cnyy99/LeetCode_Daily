#
# @lc app=leetcode id=1002 lang=python3
#
# [1002] Find Common Characters
#
# https://leetcode.com/problems/find-common-characters/description/
#
# algorithms
# Easy (69.05%)
# Total Accepted:    17.1K
# Total Submissions: 25.9K
# Testcase Example:  '["bella","label","roller"]'
#
# Given an array A of strings made only from lowercase letters, return a list
# of all characters that show up in all strings within the list (including
# duplicates).  For example, if a character occurs 3 times in all strings but
# not 4 times, you need to include that character three times in the final
# answer.
#
# You may return the answer in any order.
#
#
#
#
# Example 1:
#
#
# Input: ["bella","label","roller"]
# Output: ["e","l","l"]
#
#
#
# Example 2:
#
#
# Input: ["cool","lock","cook"]
# Output: ["c","o"]
#
#
#
#
# Note:
#
#
# 1 <= A.length <= 100
# 1 <= A[i].length <= 100
# A[i][j] is a lowercase letter
#
#
#
#


class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        # charcount =[0 for _ in range(26)]
        # for t in A[0]:
        #     charcount[ord(t)-ord('a')]+=1
        # for str in A[1:]:
        #     tempcount =[0 for _ in range(26)]
        #     for t in str:
        #         tempcount[ord(t)-ord('a')]+=1
        #     for j in range(0,26):
        #         charcount[j]=min(charcount[j],tempcount[j])
        # sol=[]
        # for i in range(0,26):
        #     for j in range(charcount[i]):
        #         sol.append(chr(ord('a')+i))
        # return sol
        unique_letters = set(A[0])
        res = []
        for letter in unique_letters:
            min_count = -1
            for word in A:
                count = word.count(letter)
                if count == 0:
                    min_count = -1
                    break
                if count < min_count or min_count == -1:
                    min_count = count
            while min_count > 0:
                res.append(letter)
                min_count -= 1
        return res
