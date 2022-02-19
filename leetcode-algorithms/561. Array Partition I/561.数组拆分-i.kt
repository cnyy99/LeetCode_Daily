/*
 * @lc app=leetcode.cn id=561 lang=kotlin
 *
 * [561] 数组拆分 I
 *
 * https://leetcode-cn.com/problems/array-partition-i/description/
 *
 * algorithms
 * Easy (77.70%)
 * Likes:    285
 * Dislikes: 0
 * Total Accepted:    99K
 * Total Submissions: 127.3K
 * Testcase Example:  '[1,4,3,2]'
 *
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn)
 * ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 
 * 返回该 最大总和 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2
 * + 6 = 9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * nums.length == 2 * n
 * -10^4 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        // 实现快速排序
        quickSort(nums, 0, nums.lastIndex)
        // 自带排序算法
        // nums.sort()
        var sum = 0
        for (i in nums.indices step 2) {
            // 取排序好的数组中的偶数位元素相加
            sum += nums[i]
        }
        return sum
    }

    // 实现快速排序
    private fun quickSort(nums: IntArray, l: Int, r: Int) {
        if (l < r) {
            // 找到一个划分
            val index = partition(nums, l, r)
            // 递归快速排序左半部分
            quickSort(nums, l, index - 1)
            // 递归快速排序右半部分
            quickSort(nums, index + 1, r)
        }
    }

    // 划分方法
    fun partition(nums: IntArray, l: Int, r: Int): Int {
        // 选取最左边的下标作为中枢
        // 将小于该值的元素移动到该元素的左边
        // 将大于该值的元素移动到该元素的右边
        val pivot = l
        // 从中枢的下一个位置开始移动
        var index = l + 1
        for (i in (l + 1)..r) {
            // 遍历从 l + 1 到r的位置
            if (nums[i] < nums[pivot]) {
                // 如果当前元素小于中枢元素的值，和index位置的元素交换
                // index位置往后移动一位
                nums.swapInPlace(i, index++)
            }
        }
        // 循环结束后，index位置为中枢所在位置的下一个位置
        // 所以index位置先减1，然后与中枢位置进行交换
        nums.swapInPlace(l, --index)
        println(nums.joinToString())
        // 返回中枢元素的位置
        return index
    }

    // 数组swap扩展方法
    private fun IntArray.swapInPlace(l: Int, r: Int) {
        // 交换该array的l、r位置
        this[l] = this[r].also { this[r] = this[l] }
    }
}
// @lc code=end

