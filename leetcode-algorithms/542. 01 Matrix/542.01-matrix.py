#
# @lc app=leetcode id=542 lang=python3
#
# [542] 01 Matrix
#
# https://leetcode.com/problems/01-matrix/description/
#
# algorithms
# Medium (37.24%)
# Likes:    894
# Dislikes: 90
# Total Accepted:    58.3K
# Total Submissions: 155.9K
# Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
#
# Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
# each cell.
# 
# The distance between two adjacent cells is 1.
# 
# 
# 
# Example 1: 
# 
# 
# Input:
# [[0,0,0],
# ⁠[0,1,0],
# ⁠[0,0,0]]
# 
# Output:
# [[0,0,0],
# [0,1,0],
# [0,0,0]]
# 
# 
# Example 2: 
# 
# 
# Input:
# [[0,0,0],
# ⁠[0,1,0],
# ⁠[1,1,1]]
# 
# Output:
# [[0,0,0],
# ⁠[0,1,0],
# ⁠[1,2,1]]
# 
# 
# 
# 
# Note:
# 
# 
# The number of elements of the given matrix will not exceed 10,000.
# There are at least one 0 in the given matrix.
# The cells are adjacent in only four directions: up, down, left and right.
# 
# 
#

# @lc code=start
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        def hasNeiberZero(row, col, matrix):
            if row > 0 and matrix[row - 1][col] == 0:
                return True
            if (row < len(matrix) - 1 and matrix[row + 1][col] == 0):
                return True
            if (col > 0 and matrix[row][col - 1] == 0):
                return True
            if (col < len(matrix[0]) - 1 and matrix[row][col + 1] == 0):
                return True
            return False

        def dfs(matrix, row, col, val):
            if (row < 0 or col < 0 or col >= len(matrix[0]) or row >= len(matrix)
                    or (matrix[row][col] <= val and val != 1)):
                return
            matrix[row][col] = val

            dfs(matrix, row + 1, col, matrix[row][col] + 1)
            dfs(matrix, row - 1, col, matrix[row][col] + 1)
            dfs(matrix, row, col + 1, matrix[row][col] + 1)
            dfs(matrix, row, col - 1, matrix[row][col] + 1)

        if (len(matrix) == 0):
            return matrix
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if (matrix[i][j] == 1 and not hasNeiberZero(i, j, matrix)):
                    matrix[i][j] = 99999999
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if (matrix[i][j] == 1):
                    dfs(matrix, i, j, 1)
        return matrix
# @lc code=end

