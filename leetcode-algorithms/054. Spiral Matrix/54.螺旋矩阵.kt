/*
 * @lc app=leetcode.cn id=54 lang=kotlin
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (48.63%)
 * Likes:    1069
 * Dislikes: 0
 * Total Accepted:    252.1K
 * Total Submissions: 518K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 
 * -100 
 * 
 * 
 */
// [[1,2,3,4],
//  [5,6,7,8],
//  [9,10,11,12],
//  [13,14,15,16]]
// @lc code=start
class Solution {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        // 结果
        val result = ArrayList<Int>(matrix.size * matrix[0].size)
        // 行的上界
        var rowMin = 0
        // 行的下界
        var rowMax = matrix.lastIndex
        // 列的左界
        var colMin = 0
        // 列的右界
        var colMax = matrix[0].lastIndex

        while (true) {
            // 向右
            for (i in colMin..colMax) {
                result.add(matrix[rowMin][i])
            }
            // 判断是否遍历结束
            if (++rowMin > rowMax) {
                break
            }
            // 向下
            for (i in rowMin..rowMax) {
                result.add(matrix[i][colMax])
            }
            // 判断是否遍历结束
            if (colMin > --colMax) {
                break
            }
            // 向左
            for (i in colMax downTo colMin) {
                result.add(matrix[rowMax][i])
            }
            // 判断是否遍历结束
            if (rowMin > --rowMax) {
                break
            }
            // 向上
            for (i in rowMax downTo rowMin) {
                result.add(matrix[i][colMin])
            }
            // 判断是否遍历结束
            if (++colMin > colMax) {
                break
            }
        }
        return result
    }
}

// @lc code=end

