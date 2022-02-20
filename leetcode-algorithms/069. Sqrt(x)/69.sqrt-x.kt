/*
 * @lc app=leetcode.cn id=69 lang=kotlin
 *
 * [69] Sqrt(x)
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (39.04%)
 * Likes:    894
 * Dislikes: 0
 * Total Accepted:    458.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '4'
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 4
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= x <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    fun mySqrt(x: Int): Int {
        if (x < 2) {
            // 小于2时直接返回答案
            return x
        }
        var left = 0
        var right = x
        while (left <= right) {
            // 计算中间值
            val mid = left + (right - left) / 2
            if (x / mid == mid) {
                // 如果x / mid等于mid的话，代表sqrt(x)的整数部分是mid，此时找到答案
                return mid
            } else if (x / mid > mid) {
                // 此时mid小于sqrt(x)，所以答案应在(mid+1)<->right之间
                left = mid + 1
            } else {
                // 此时mid大于sqrt(x)，所以答案应在left<->(mid-1)之间
                right = mid - 1
            }
        }
        return right
    }
}


// @lc code=end

