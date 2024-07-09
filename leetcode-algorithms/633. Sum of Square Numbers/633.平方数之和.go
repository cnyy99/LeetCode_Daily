/*
 * @lc app=leetcode.cn id=633 lang=golang
 *
 * [633] 平方数之和
 *
 * https://leetcode.cn/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Medium (38.05%)
 * Likes:    456
 * Dislikes: 0
 * Total Accepted:    141.5K
 * Total Submissions: 372.3K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 *
 * 示例 2：
 *
 *
 * 输入：c = 3
 * 输出：false
 *
 *
 *
 *
 * 提示：
 *
 *
 * 0 <= c <= 2^31 - 1
 *
 *
 */

// @lc code=start
func judgeSquareSum(c int) bool {
	// 使用左右双指针

	// 先找到右边的上限，也就是c的平方根
	var right = int(math.Sqrt(float64(c)))
	// 左侧下限0
	var left = 0
	// 直到左右两侧相遇
	for left <= right {
		// 计算他们的平方和
		value := left*left + right*right
		// 大于c的话，右侧-1
		if value > c {
			right--
			// 小于c的话，左侧+1
		} else if value < c {
			left++
			// 等于代表找到了
		} else {
			return true
		}
	}
	// 跳出循环代表没找到
	return false
}

// @lc code=end

