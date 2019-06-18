#
# @lc app=leetcode id=79 lang=python3
#
# [79] Word Search
#
# https://leetcode.com/problems/word-search/description/
#
# algorithms
# Medium (30.46%)
# Likes:    1780
# Dislikes: 87
# Total Accepted:    288.6K
# Total Submissions: 918.2K
# Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
#
# Given a 2D board and a word, find if the word exists in the grid.
#
# The word can be constructed from letters of sequentially adjacent cell, where
# "adjacent" cells are those horizontally or vertically neighboring. The same
# letter cell may not be used more than once.
#
# Example:
#
#
# board =
# [
# ⁠ ['A','B','C','E'],
# ⁠ ['S','F','C','S'],
# ⁠ ['A','D','E','E']
# ]
#
# Given word = "ABCCED", return true.
# Given word = "SEE", return true.
# Given word = "ABCB", return false.
#
#
#


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(board, row, col, word):
            if not word:
                return True
            if row<0 or col<0 or row>=len(board) or col>=len(board[0]) or word[0]!=board[row][col]:
                return False
            ch = board[row][col]
            board[row][col] = '.'
            newword = word[1:]
            result = dfs(board, row - 1, col, newword)  or  dfs(board, row, col - 1, newword)  or  dfs(board, row + 1, col, newword)  or  dfs(board, row, col + 1, newword)
            board[row][col]=ch
            return result
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(board, i, j, word):
                    return True
        return False
