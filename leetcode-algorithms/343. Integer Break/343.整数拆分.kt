/*
 * @lc app=leetcode.cn id=343 lang=kotlin
 *
 * [343] 整数拆分
 *
 * https://leetcode-cn.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (61.32%)
 * Likes:    760
 * Dislikes: 0
 * Total Accepted:    147.8K
 * Total Submissions: 240.3K
 * Testcase Example:  '2'
 *
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 
 * 返回 你可以获得的最大乘积 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 
 * 示例 2:
 * 
 * 
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 2 <= n <= 58
 * 
 * 
 */

// @lc code=start
class Solution {
    fun integerBreak(n: Int): Int {
        // 分的结果中有最多的3时，结果最大
        return when (n) {
            // 特殊情况
            2, 3 -> n - 1
            // 其他情况
            else -> {
                // 计算3的个数
                val count = (n / 3).toDouble()
                // 整除3之后的余数
                val remain = n % 3
                // 针对余数的不同进行处理
                when (remain) {
                    // 余数为0，n能够被3整除，结果就是 3^count
                    0 -> Math.pow(3.0, count)
                    // 余数为1，余数为1，结果就是 3^(count-1)*4
                    1 -> Math.pow(3.0, (count - 1)) * 4
                    // 余数为2，余数为2，结果就是 3^count*2
                    else -> Math.pow(3.0, count) * 2
                }.toInt()
            }
        }
    }
}
// @lc code=end

