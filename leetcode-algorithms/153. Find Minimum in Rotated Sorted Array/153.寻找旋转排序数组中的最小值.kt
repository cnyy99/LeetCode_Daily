/*
 * @lc app=leetcode.cn id=153 lang=kotlin
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (56.87%)
 * Likes:    668
 * Dislikes: 0
 * Total Accepted:    248.8K
 * Total Submissions: 437K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7]
 * 在变化后可能得到：
 * 
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 
 * 
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
 * ..., a[n-2]] 。
 * 
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums.length
 * 1 
 * -5000 
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * 
 * 
 */

// @lc code=start
class Solution {
    // 二分查找
    fun findMin(nums: IntArray): Int {
        // 左侧下标
        var left = 0
        // 右侧下标
        var right = nums.lastIndex
        while (left < right) {
            // 左右不相等时
            // 中间位置为mid
            val mid = (right + left) / 2

            if (nums[mid] > nums[right]) {
                // 中间位置大于右侧时，代表最小值肯定在中间位置到右侧之间
                // 且最小值不可能为当前位置
                // 更新左侧为中间位置的下一个位置
                left = mid + 1
            } else {
                // 中间位置小于右侧时，代表最小值肯定在中间位置到左侧之间
                // 且最小值可能是当前位置
                // 所以更新右侧为当前位置
                right = mid
            }
        }
        return nums[left]
    }

    // 线性查找
    fun findMinLinear(nums: IntArray): Int {
        // 先取第一个位置
        var result = nums[0]
        for (num in nums) {
            // 遍历所有数字
            if (num < result) {
                // 遇到变小时返回
                return num
            }
        }
        // 没遇到时，第一个数字即为最小的值
        return result
    }
}
// @lc code=end

