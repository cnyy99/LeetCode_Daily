#
# @lc app=leetcode.cn id=852 lang=python3
#
# [852] 山脉数组的峰顶索引
#
# https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/
#
# algorithms
# Medium (68.38%)
# Likes:    406
# Dislikes: 0
# Total Accepted:    165.9K
# Total Submissions: 242.6K
# Testcase Example:  '[0,1,0]'
#
# 给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
#
# 返回峰值元素的下标。
#
# 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
#
#
#
# 示例 1：
#
#
# 输入：arr = [0,1,0]
# 输出：1
#
#
# 示例 2：
#
#
# 输入：arr = [0,2,1,0]
# 输出：1
#
#
# 示例 3：
#
#
# 输入：arr = [0,10,5,2]
# 输出：1
#
#
#
#
# 提示：
#
#
# 3 <= arr.length <= 10^5
# 0 <= arr[i] <= 10^6
# 题目数据 保证 arr 是一个山脉数组
#
#
#


# @lc code=start
class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        # 首和尾肯定不是最大值，所以遍历[1, len(arr) - 2]即可
        left, right, ans = 1, len(arr) - 2, 0
        while left <= right:
            mid = (left + right) // 2
            if arr[mid] > arr[mid + 1]:
                # 中间值大于右边的值时，代表最大值在[left, mid]中
                # 或者mid本身就是最大值，先记录下ans=mid，当后续再进入该分支时再更新
                # 所以后续只需要遍历[left, mid-1]即可，当不满足条件时会跳出循环，返回ans
                ans = mid
                right = mid - 1
            else:
                # 中间值小于右边的值时，代表最大值在[mid+1,right]之间
                left = mid + 1
        # 返回最后的结果
        return ans


# @lc code=end
