/*
 * @lc app=leetcode.cn id=7 lang=kotlin
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Medium (35.11%)
 * Likes:    3363
 * Dislikes: 0
 * Total Accepted:    930.5K
 * Total Submissions: 2.6M
 * Testcase Example:  '123'
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 123
 * 输出：321
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = -123
 * 输出：-321
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 120
 * 输出：21
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：x = 0
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun reverse(x: Int): Int {
        // 判断正负
        var isPositive = if (x >= 0) true else false
        // 变成正值
        var num = Math.abs(x)
        // 记录最终结果
        var result = 0
        while (num != 0) {
            // 计算本次结果
            val temp = result * 10 + num % 10
            // 判断结果是否超过int上限
            if (temp / 10 != result) {
                // 超过上限返回0
                return 0
            }
            // 更新result
            result = temp
            // 更新sum，处理下一位
            num /= 10
        }
        // 返回正确的正负
        return if (isPositive) result else -result
    }
}

// @lc code=end

