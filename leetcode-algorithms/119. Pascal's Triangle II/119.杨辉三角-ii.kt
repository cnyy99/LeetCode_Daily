/*
 * @lc app=leetcode.cn id=119 lang=kotlin
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (67.59%)
 * Likes:    364
 * Dislikes: 0
 * Total Accepted:    174.4K
 * Total Submissions: 257.4K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: rowIndex = 0
 * 输出: [1]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 0 
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 * 
 */

// @lc code=start
class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        // 初始化为全是1
        val result = Array(rowIndex + 1) { 1 }
        // 如果rowIndex小于2，直接返回
        if (rowIndex < 2) {
            return result.toList()
        }
        for (i in 2..rowIndex) {
            // 从第三行开始
            for (j in i - 1 downTo 1) {
                // 从后往前更新数据为前一行对应两个位置的和，从后往前更新不会影响接下来的数据
                result[j] = result[j] + result[j - 1]
            }
        }
        return result.toList()
    }
}
// @lc code=end

