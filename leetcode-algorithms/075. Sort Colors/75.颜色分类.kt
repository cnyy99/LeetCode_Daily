/*
 * @lc app=leetcode.cn id=75 lang=kotlin
 *
 * [75] 颜色分类
 *
 * https://leetcode-cn.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (60.07%)
 * Likes:    1146
 * Dislikes: 0
 * Total Accepted:    316.7K
 * Total Submissions: 527.1K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 
 * 
 * 
 * 
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 
 * 
 */

// @lc code=start
class Solution {
    // 0移动到最左边，2移动到最右边，此时1就已经在中间了
    fun sortColors(nums: IntArray): Unit {
        var left = 0
        var right = nums.size - 1
        var i = 0
        while(i <= right) {
            if(nums[i] == 0) {
                // 0移动到最左边, 遍历过的元素里不存在2，所以下一次直接处理下个元素，i自增
                swap(nums, i++, left++)
            } else if (nums[i] == 2) {
                // 2移动到最右边，移动过来的元素可能是0，所以下一次需要处理移动过来的元素，这里i不自增
                swap(nums, i, right--)
            } else {
                // 1不动，继续处理下一个
                i++
            }
        }
    }

    private fun swap(nums: IntArray, left: Int, right: Int){
        val temp = nums[right]
        nums[right] = nums[left]
        nums[left] = temp
    }

    //以下为计数排序，第一次遍历统计每种颜色的个数，第二次填进去
    fun countSortColors(nums:IntArray): Unit {
        var count0 = 0
        var count1 = 0
        var count2 = 0
        nums.forEach{
            when(it) {
                0 -> ++count0
                1 -> ++count1
                2 -> ++count2
            }
        }
        var i = 0
        repeat(count0) {
            nums[i++] = 0
        }
        repeat(count1) {
            nums[i++] = 1
        }
        repeat(count2) {
            nums[i++] = 2
        }
    }
}
// @lc code=end

