/*
 * @lc app=leetcode.cn id=9 lang=kotlin
 *
 * [9] 回文数
 *
 * https://leetcode.cn/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (57.12%)
 * Likes:    2182
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 2M
 * Testcase Example:  '121'
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 
 * 例如，121 是回文，而 123 不是。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 121
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 <= x <= 2^31 - 1
 * 
 * 
 * 
 * 
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * 
 */

// @lc code=start
class Solution {
    fun isPalindrome(x: Int): Boolean {
        // 负数一定不是回文数
        if (x < 0) {
            return false
        }
        // 存储反转之后的数字
        var result = 0
        // 复制一份可变的x
        var vx = x
        // vx大于0时
        while (vx > 0) {
            // 记录反转之后的数字
            result = result * 10 + vx % 10
            if (result < 0) {
                // 反转之后的数字如果发生溢出
                // 则一定不是回文数，返回false
                return false
            }
            // 遍历vx的下一位
            vx /= 10
        }
        // 判断反转之后的数字和原数字是否相同
        return result == x
    }
}

// @lc code=end

