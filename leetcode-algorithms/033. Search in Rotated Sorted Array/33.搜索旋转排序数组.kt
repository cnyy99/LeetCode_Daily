/*
 * @lc app=leetcode.cn id=33 lang=kotlin
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (43.20%)
 * Likes:    1845
 * Dislikes: 0
 * Total Accepted:    447.1K
 * Total Submissions: 1M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 ）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
 * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如，
 * [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1], target = 0
 * 输出：-1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10^4 
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 
 * 
 * 
 * 
 * 
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 * 
 */

// @lc code=start
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums[nums.lastIndex] > nums[0]) {
            // 此时数组整体有序，直接进行二分查找
            return binarySearch(nums, target, 0, nums.lastIndex)
        }
        // 找到最小值所在的位置，在pivot前后都是有序的了
        val pivot = findMin(nums)

        if (target <= nums[nums.lastIndex]) {
            // target小于等于最后一个元素时，target在后半部分的有序子数组中
            return binarySearch(nums, target, pivot, nums.lastIndex)
        } else {
            // 否则target在前半部分的有序子数组中
            return binarySearch(nums, target, 0, pivot - 1)
        }
    }

    // 在l-r区间内进行二分查找
    private fun binarySearch(nums: IntArray, target: Int, l: Int, r: Int): Int {
        var left = l
        var right = r
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1
    }

    // 查找最小值所在的位置
    private fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[right] > nums[mid]) {
                // 右侧大于中间值时，中间值可能是最小值
                right = mid
            } else {
                // 左侧大于中间值时，中间值不可能是最小值
                left = mid + 1
            }
        }
        // 返回最小值在的位置
        return right
    }
}



// @lc code=end

