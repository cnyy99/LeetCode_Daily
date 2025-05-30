#
# @lc app=leetcode.cn id=410 lang=python3
#
# [410] 分割数组的最大值
#
# https://leetcode.cn/problems/split-array-largest-sum/description/
#
# algorithms
# Hard (60.57%)
# Likes:    989
# Dislikes: 0
# Total Accepted:    94.2K
# Total Submissions: 155.5K
# Testcase Example:  '[7,2,5,10,8]\n2'
#
# 给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。
#
# 设计一个算法使得这 k 个子数组各自和的最大值最小。
#
#
#
# 示例 1：
#
#
# 输入：nums = [7,2,5,10,8], k = 2
# 输出：18
# 解释：
# 一共有四种方法将 nums 分割为 2 个子数组。
# 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
# 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
#
# 示例 2：
#
#
# 输入：nums = [1,2,3,4,5], k = 2
# 输出：9
#
#
# 示例 3：
#
#
# 输入：nums = [1,4,4], k = 3
# 输出：4
#
#
#
#
# 提示：
#
#
# 1 <= nums.length <= 1000
# 0 <= nums[i] <= 10^6
# 1 <= k <= min(50, nums.length)
#
#
#


# @lc code=start
class Solution:
    # 题解参考：https://leetcode.cn/leetbook/read/learning-algorithms-with-leetcode/x4mixi/
    def splitArray(self, nums: List[int], k: int) -> int:
        # 分割出来的值的最小值为 整个数组的最大值
        # 最大值，k=1时，就是整个数组的和
        left, right = max(nums), sum(nums)
        # 遍历[left, right]
        while left < right:
            mid = (left + right) // 2
            # 计算中间mid的分割数是多少
            if self.getSplit(nums, mid) > k:
                # 多于k时代表分割太少，再在[mid+1, right]中搜索
                left = mid + 1
            else:
                # 少于等于k时代表分割太多，再在[left, mid]中搜索
                right = mid
        return left

    def getSplit(self, nums, target):
        # 初始化最少划分为1个
        # 当前分割的和为0
        ans, current_sum = 1, 0
        for num in nums:
            if (current_sum + num) > target:
                # 如果current_sum + num 大于target了，代表当前分割已结束
                ans += 1
                # 重置分割的和为0
                current_sum = 0
            current_sum += num

        # 返回当依据target进行划分时，最终的分割个数
        return ans


# @lc code=end
