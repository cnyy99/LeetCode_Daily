/*
 * @lc app=leetcode.cn id=118 lang=kotlin
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (73.95%)
 * Likes:    686
 * Dislikes: 0
 * Total Accepted:    261.8K
 * Total Submissions: 353.2K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
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
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: numRows = 1
 * 输出: [[1]]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>(numRows)
        // 第一行
        result.add(listOf(1))
        for (colNum in 1 until numRows) {
            // 从第2行到第numRows行
            // 初始化这一行
            val row = ArrayList<Int>(colNum + 1)
            // 添加第一个元素1
            row.add(1)
            for (j in 1 until colNum) {
                // 添加中间的元素，为上一行的两个对应位置的和
                row.add(result[colNum - 1][j - 1] + result[colNum - 1][j])
            }
            // 添加最后一个元素1
            row.add(1)
            // 添加该行到结果中
            result.add(row)
        }
        return result
    }
}
// @lc code=end

