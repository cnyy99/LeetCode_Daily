/*
 * @lc app=leetcode.cn id=11 lang=kotlin
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (62.10%)
 * Likes:    3169
 * Dislikes: 0
 * Total Accepted:    624.9K
 * Total Submissions: 1M
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 示例 2：
 * 
 * 
 * 输入：height = [1,1]
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：height = [1,2,1]
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    fun maxArea(height: IntArray): Int {
        // 左指针
        var left = 0
        // 右指针
        var right = height.size - 1
        // 能存放的最多的水
        var max = 0
        while (left < right) {
            // 容器的长度
            val length = right - left
            // 左右挡板中短的那个
            val short = Math.min(height[left], height[right])
            // 更新水的最大值
            max = Math.max(short * length, max)
            if (height[left] > height[right]) {
                // 右侧挡板更短时
                // 右指针往左移动
                right--
            } else {
                // 左侧挡板更短时
                // 左指针往右移动
                left++
            }
        }
        return max
    }
}
// @lc code=end

