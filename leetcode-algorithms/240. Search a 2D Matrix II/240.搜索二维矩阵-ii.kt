/*
 * @lc app=leetcode.cn id=240 lang=kotlin
 *
 * [240] 搜索二维矩阵 II
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/
 *
 * algorithms
 * Medium (50.20%)
 * Likes:    955
 * Dislikes: 0
 * Total Accepted:    245.5K
 * Total Submissions: 486.6K
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n' +
  '5'
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 
 * 
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 5
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 20
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.size == 0 || matrix[0].size == 0) {
            return false
        }
        // 从右上角开始看，左边的元素比它小，下边的元素比它大
        // 所以构成了一颗二叉搜索树
        var row = 0
        var col = matrix[0].lastIndex
        // 下标在合法范围内
        while (row >= 0 && col >= 0 && row < matrix.size && col < matrix[0].size) {
            if (matrix[row][col] == target) {
                // 找到目标元素，返回true
                return true
            } else if (matrix[row][col] > target) {
                // 往小的方向（左）移动
                --col
            } else {
                // 往大的方向（又）移动
                ++row
            }
        }
        // 没找到时不存在该元素，返回false
        return false
    }
}
// @lc code=end

