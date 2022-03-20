/*
 * @lc app=leetcode.cn id=79 lang=kotlin
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (46.17%)
 * Likes:    1226
 * Dislikes: 0
 * Total Accepted:    284.6K
 * Total Submissions: 616.5K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 * 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 *
 *
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "SEE"
 * 输出：true
 *
 *
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCB"
 * 输出：false
 *
 *
 *
 *
 * 提示：
 *
 *
 * m == board.length
 * n = board[i].length
 * 1
 * 1
 * board 和 word 仅由大小写英文字母组成
 *
 *
 *
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 */

// @lc code=start
class Solution {

    // visit 数组，记录访问情况
    private lateinit var visit: Array<BooleanArray>
    fun exist(board: Array<CharArray>, word: String): Boolean {
        // 初始化 visit 数组
        visit = Array(board.size) { BooleanArray(board[0].size) }
        for (i in board.indices) {
            for (j in board[0].indices) {
                // 从每个位置出发，判断是否有满足条件的答案
                if (helper(board, i, j, word, 0)) {
                    // 找到答案，返回true
                    return true
                }
            }
        }
        // 没找到答案，返回false
        return false
    }
    // helper方法，递归求解
    private fun helper(board: Array<CharArray>, row: Int, col: Int, word: String, index: Int): Boolean {
        if (index >= word.length) {
            // 此时代表 word 已经便利完了，返回true
            return true
        }
        if (row !in board.indices || col !in board[0].indices || visit[row][col]) {
            // 判断当前位置是否合法，或者是否已经被访问过
            return false
        }
        // 当前位置 visit 置为 true
        visit[row][col] = true
        var result = false
        if (word[index] == board[row][col]) {
            // 当前位置与 word index位置处的字母相等，计算下一次需要处理的下标
            val newIndex = index + 1
            // 递归处理下四个方向的结果，有一个为 true，答案即为 true
            result = helper(board, row + 1, col, word, newIndex) ||
                helper(board, row, col + 1, word, newIndex) ||
                helper(board, row - 1, col, word, newIndex) ||
                helper(board, row, col - 1, word, newIndex)
        }
        // 重新将 visit 当前位置置为 false，以便让下次处理时能处理到当前位置
        visit[row][col] = false
        // 返回结果
        return result
    }
}
// @lc code=end
