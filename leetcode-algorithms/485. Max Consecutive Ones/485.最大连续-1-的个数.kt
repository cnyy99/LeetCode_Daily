/*
 * @lc app=leetcode.cn id=485 lang=kotlin
 *
 * [485] 最大连续 1 的个数
 *
 * https://leetcode-cn.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (60.91%)
 * Likes:    296
 * Dislikes: 0
 * Total Accepted:    138.1K
 * Total Submissions: 226.7K
 * Testcase Example:  '[1,1,0,1,1,1]'
 *
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1.
 * 
 * 
 */

// @lc code=start
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var result = 0
        var count = 0
        for (num in nums) {
            if (num == 0) {
                // 遇到0时更新result为最大的count
                result = count.coerceAtLeast(result)
                // count重置为0
                count = 0
            } else {
                // 遇到1时count加1
                count++
            }
        }
        // 返回最大的count
        return count.coerceAtLeast(result)
    }
}
// @lc code=end

