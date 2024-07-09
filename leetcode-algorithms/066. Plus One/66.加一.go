/*
 * @lc app=leetcode.cn id=66 lang=golang
 *
 * [66] 加一
 *
 * https://leetcode.cn/problems/plus-one/description/
 *
 * algorithms
 * Easy (45.60%)
 * Likes:    1401
 * Dislikes: 0
 * Total Accepted:    752.9K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 *
 * 示例 2：
 *
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 *
 * 示例 3：
 *
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * 0
 *
 *
 */

// @lc code=start
func plusOne(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		// 当前位+1，最开始是最后一位
		digits[i]++
		// 模10取余
		digits[i] %= 10
		// 如果是0，代表是10，下一位+1
		// 不是0，代表不进位，运算结束，直接返回
		if digits[i] != 0 {
			return digits
		}
	}
	// 走到这里代表最后还要进1位，并且其他位都是0
	result := make([]int, len(digits)+1)
	result[0] = 1
	return result
}

// @lc code=end

