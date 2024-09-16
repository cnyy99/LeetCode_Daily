#
# @lc app=leetcode.cn id=69 lang=python3
#
# [69] x 的平方根
#
# https://leetcode.cn/problems/sqrtx/description/
#
# algorithms
# Easy (38.62%)
# Likes:    1585
# Dislikes: 0
# Total Accepted:    955.4K
# Total Submissions: 2.5M
# Testcase Example:  '4'
#
# 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
#
# 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
#
# 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
#
#
#
# 示例 1：
#
#
# 输入：x = 4
# 输出：2
#
#
# 示例 2：
#
#
# 输入：x = 8
# 输出：2
# 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
#
#
#
#
# 提示：
#
#
# 0 <= x <= 2^31 - 1
#
#
#


# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        # 可能的最小值和最大值，比如x是0，1
        left, right = 0, x
        # 记录结果
        res = 0
        while left <= right:
            # 计算中间值
            mid = (left + right) // 2
            if mid * mid <= x:
                # 小于等于x时，记录当前的mid为res
                # 最终结果在[mid,right]中
                left = mid + 1
                res = mid
            else:
                # 最终结果在[left,mid-1]中
                right = mid - 1
        return res


# @lc code=end
