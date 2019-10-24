/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (30.46%)
 * Likes:    1780
 * Dislikes: 87
 * Total Accepted:    288.6K
 * Total Submissions: 918.2K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(0) != board[row][col]) {
            return false;
        }
        char ch = board[row][col];
        board[row][col] = '.';
        String newword = word.substring(1);
        boolean result = dfs(board, row - 1, col, newword) || dfs(board, row, col - 1, newword)
                || dfs(board, row + 1, col, newword) || dfs(board, row, col + 1, newword);
        board[row][col] = ch;
        return result;
    }
}
