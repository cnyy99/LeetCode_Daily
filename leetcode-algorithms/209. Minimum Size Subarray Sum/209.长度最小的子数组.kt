/*
 * @lc app=leetcode.cn id=209 lang=kotlin
 *
 * [209] 长度最小的子数组
 *
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (47.88%)
 * Likes:    931
 * Dislikes: 0
 * Total Accepted:    251.3K
 * Total Submissions: 523.1K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
 * ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * 
 * 
 */

// @lc code=start
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        // 标记是否找到了满足条件的子数据，未找到时result为nums.size + 1，此时返回0
        var result = nums.size + 1
        // 满足条件的左侧指针
        var left = 0
        // 满足条件的右侧指针
        var right = -1
        // 存储子数组的和
        var sum = 0
        var maxIndex = nums.size - 1
        while (right < maxIndex) {
            while (right < maxIndex && sum < target) {
                // 子数组的和小于target时，扩从子数组
                sum += nums[++right]
            }
            while (sum >= target) {
                // 子数组的和大于target时更新子数组的长度为较小的
                result = Math.min(result, right - left + 1)
                // 从左侧缩短子数组
                sum -= nums[left++]
            }
        }
        return if (result == nums.size + 1) 0 else result
    }
}
// @lc code=end

