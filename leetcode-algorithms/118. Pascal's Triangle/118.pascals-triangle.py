#
# @lc app=leetcode id=118 lang=python3
#
# [118] Pascal's Triangle
#
# https://leetcode.com/problems/pascals-triangle/description/
#
# algorithms
# Easy (44.68%)
# Total Accepted:    241.2K
# Total Submissions: 532.3K
# Testcase Example:  '5'
#
# Given a non-negative integer numRows, generate the first numRows of Pascal's
# triangle.
#
#
# In Pascal's triangle, each number is the sum of the two numbers directly
# above it.
#
# Example:
#
#
# Input: 5
# Output:
# [
# ⁠    [1],
# ⁠   [1,1],
# ⁠  [1,2,1],
# ⁠ [1,3,3,1],
# ⁠[1,4,6,4,1]
# ]
#
#
#


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        map = [[]for _ in range(numRows)]
        for i in range(numRows):
            tmp = [1 for _ in range(i+1)]
            map[i] = tmp
            # map[i][0]=map[i][i]=1;
        if numRows > 2:
            for i in range(2, numRows):
                for j in range(1, i):
                    map[i][j] = (map[i - 1][j] + map[i - 1][j - 1])
        return map
