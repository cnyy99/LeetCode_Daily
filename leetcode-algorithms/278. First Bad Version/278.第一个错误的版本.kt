/*
 * @lc app=leetcode.cn id=278 lang=kotlin
 *
 * [278] 第一个错误的版本
 *
 * https://leetcode-cn.com/problems/first-bad-version/description/
 *
 * algorithms
 * Easy (45.14%)
 * Likes:    589
 * Dislikes: 0
 * Total Accepted:    270.4K
 * Total Submissions: 599.2K
 * Testcase Example:  '5\n4'
 *
 * 
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version
 * 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false 
 * 调用 isBadVersion(5) -> true 
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1, bad = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        // 最小版本
        var left = 1
        // 最大版本
        var right = n
        while (left < right) {
            // 中间版本
            val mid = left + (right - left) / 2
            // 中间版本是否是badVersion
            val isBad = isBadVersion(mid)
            if (isBad) {
                // 是的话右侧换位该版本
                // 而且该版本可能为最小出错的版本
                right = mid
            } else {
                // 不是的话左侧换位该版本的下一个版本
                // 该版本不可能是最小出错的版本
                left = mid + 1
            }
        }
        // 返回最后找到的结果
        return left
    }
}

// @lc code=end

