/*
 * @lc app=leetcode id=79 lang=cpp
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
public:
    bool exist(vector<vector<char>>& board, string word) {
        for (auto i = 0; i < board.size();i++)
        {
            for (auto j = 0; j < board[0].size();j++)
            {
                if(dfs(board,i,j,word))
                {
                    return true;
                }
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>>& board,int row,int col,string& word)
    {
        if(word.empty())
        {
            return true;
        }
        if(row<0||col<0||row>=board.size()||col>=board[0].size()||word[0]!=board[row][col])
        {
            return false;
        }
        char ch = board[row][col];
        board[row][col] = '.';
        string newword = word.substr(1);
        bool result = dfs(board, row - 1, col, newword) || dfs(board, row, col - 1, newword) || dfs(board, row + 1, col, newword) || dfs(board, row, col + 1, newword);
        board[row][col]=ch;
        return result;
    }
};
