#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#
# https://leetcode.com/problems/number-of-islands/description/
#
# algorithms
# Medium (42.46%)
# Likes:    3014
# Dislikes: 109
# Total Accepted:    408K
# Total Submissions: 958.3K
# Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
#
# Given a 2d grid map of '1's (land) and '0's (water), count the number of
# islands. An island is surrounded by water and is formed by connecting
# adjacent lands horizontally or vertically. You may assume all four edges of
# the grid are all surrounded by water.
#
# Example 1:
#
#
# Input:
# 11110
# 11010
# 11000
# 00000
#
# Output: 1
#
#
# Example 2:
#
#
# Input:
# 11000
# 11000
# 00100
# 00011
#
# Output: 3
#
#


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def depth(grid, row, col):
            if row >= len(grid) or col >= len(grid[0]) or\
                    row < 0 or col < 0 or grid[row][col] == '0':
                return
            grid[row][col] = '0'
            depth(grid, row - 1, col)
            depth(grid, row + 1, col)
            depth(grid, row, col - 1)
            depth(grid, row, col + 1)
        num = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    num += 1
                    depth(grid, i, j)
        return num
