/*
 * @lc app=leetcode.cn id=704 lang=kotlin
 *
 * [704] 二分查找
 *
 * https://leetcode-cn.com/problems/binary-search/description/
 *
 * algorithms
 * Easy (54.65%)
 * Likes:    649
 * Dislikes: 0
 * Total Accepted:    443.4K
 * Total Submissions: 812.8K
 * Testcase Example:  '[-1,0,3,5,9,12]\n9'
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的
 * target，如果目标值存在返回下标，否则返回 -1。
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * 
 * 
 */

// @lc code=start
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        // 左侧下标
        var left = 0
        // 右侧下标
        var right = nums.lastIndex
        // 左右不相等时
        while (left <= right) {
            // 计算中间位置 不直接使用left+right避免整数溢出
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                // 相等时代表找到了答案，返回此时的下标
                return mid
            } else if (nums[mid] > target) {
                // 该位置大于target时，目标值在left<->(mid-1)之间
                right = mid - 1
            } else {
                // 该位置小于target时，目标值在(mid+1)<->right之间
                left = mid + 1
            }
        }
        // 没有找到时返回-1
        return -1
    }
}

// @lc code=end

