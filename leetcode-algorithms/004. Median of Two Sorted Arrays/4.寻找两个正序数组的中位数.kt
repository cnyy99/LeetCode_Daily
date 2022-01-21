/*
 * @lc app=leetcode.cn id=4 lang=kotlin
 *
 * [4] 寻找两个正序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (41.11%)
 * Likes:    4897
 * Dislikes: 0
 * Total Accepted:    592.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // 创建一个新数组
        val array = IntArray(nums1.size + nums2.size)
        // i 是 nums1 的指针
        var i = 0
        // j 是 nums2 的指针
        var j = 0
        // index 是新数据 array 的指针
        for (index in array.indices) {
            if (i >= nums1.size || i < nums1.size && j < nums2.size && nums1[i] > nums2[j]) {
                // nums1 已经遍历完了或者 nums1[i] > nums2[j] 时添加 nums2 到 array
                array[index] = nums2[j++]
            } else if (j >= nums2.size || i < nums1.size && j < nums2.size && nums1[i] <= nums2[j]) {
                // nums2 已经遍历完了或者 nums1[i] <= nums2[j] 时添加 nums1 到 array
                array[index] = nums1[i++]
            }
        }
        return if (array.size % 2 == 0) {
        // array 的长度是偶数，选取中间两个计算平均值
            (array[array.size / 2] + array[array.size / 2 - 1]) / 2.0
        } else {
        // array 的长度是奇数，选取中间的值
            array[array.size / 2].toDouble()
        }
    }
}
// @lc code=end

