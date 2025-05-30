#
# @lc app=leetcode.cn id=278 lang=python3
#
# [278] 第一个错误的版本
#
# https://leetcode.cn/problems/first-bad-version/description/
#
# algorithms
# Easy (45.56%)
# Likes:    1023
# Dislikes: 0
# Total Accepted:    505.1K
# Total Submissions: 1.1M
# Testcase Example:  '5\n4'
#
#
# 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
#
# 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
#
# 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version
# 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
#
#
# 示例 1：
#
#
# 输入：n = 5, bad = 4
# 输出：4
# 解释：
# 调用 isBadVersion(3) -> false
# 调用 isBadVersion(5) -> true
# 调用 isBadVersion(4) -> true
# 所以，4 是第一个错误的版本。
#
#
# 示例 2：
#
#
# 输入：n = 1, bad = 1
# 输出：1
#
#
#
#
# 提示：
#
#
# 1 <= bad <= n <= 2^31 - 1
#
#
#

# @lc code=start
# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:


class Solution:
    def firstBadVersion(self, n: int) -> int:
        # 左右端点分别为1，n
        left, right = 1, n
        while left <= right:
            # 查询mid是否是错误版本
            mid = (left + right) // 2
            isBad = isBadVersion(mid)
            if isBad:
                # 如果是错误版本，意味着目标值在[1,mid-1]中
                right = mid - 1
            else:
                # 如果不是错误版本，意味着目标值在[mid+1,right]中
                left = mid + 1
        # 返回左端点，代表是第一个出错的版本
        # 最后跳出循环是left，right不相等，并且与left与mid可能不同，在这里需要取left
        return left


# @lc code=end
