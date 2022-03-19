/*
 * @lc app=leetcode.cn id=70 lang=kotlin
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (53.44%)
 * Likes:    2265
 * Dislikes: 0
 * Total Accepted:    745.3K
 * Total Submissions: 1.4M
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

// @lc code=start
class Solution {
    fun climbStairs(n: Int): Int {

        // solution: s[i] = s[i-1] + s[i-2]
        // like Fibonacci
        if (n <= 2) {
            return n
        }
        var a = 1
        var b = 2
        repeat(n - 2) { 
            // 重复 n - 2 次
            // b 存放 a + b
            // a 存放 b
            b = (a + b).also { a = b } 
        }
        // 返回 b
        return b
    }
}

// @lc code=end

