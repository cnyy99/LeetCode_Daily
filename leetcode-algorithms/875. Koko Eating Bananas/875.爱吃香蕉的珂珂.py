#
# @lc app=leetcode.cn id=875 lang=python3
#
# [875] 爱吃香蕉的珂珂
#
# https://leetcode.cn/problems/koko-eating-bananas/description/
#
# algorithms
# Medium (49.64%)
# Likes:    630
# Dislikes: 0
# Total Accepted:    161.7K
# Total Submissions: 325.6K
# Testcase Example:  '[3,6,7,11]\n8'
#
# 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
#
# 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k
# 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
#
# 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
#
# 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
#
#
#
#
#
#
# 示例 1：
#
#
# 输入：piles = [3,6,7,11], h = 8
# 输出：4
#
#
# 示例 2：
#
#
# 输入：piles = [30,11,23,4,20], h = 5
# 输出：30
#
#
# 示例 3：
#
#
# 输入：piles = [30,11,23,4,20], h = 6
# 输出：23
#
#
#
#
# 提示：
#
#
# 1 <= piles.length <= 10^4
# piles.length <= h <= 10^9
# 1 <= piles[i] <= 10^9
#
#
#


# @lc code=start
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # 初始化最慢速的和最快速度
        left, right = 1, max(piles)
        while left < right:
            mid = (left + right) // 2
            # 计算以mid的速度吃香蕉是否会超时
            if self.getSum(piles, mid) > h:
                # 超时的话，答案在[mid+1, rihgt]之间
                left = mid + 1
            else:
                # 否则答案在[left, mid]之间, mid也有可能
                right = mid
        # 返回结果
        return left

    # 计算已speed的速度吃香蕉需要消耗的时间
    def getSum(self, piles, speed):
        ans = 0
        for p in piles:
            # 后面的值需要向上取整，所以用(p + speed - 1) // speed
            ans += (p + speed - 1) // speed
        return ans


# @lc code=end
