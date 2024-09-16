#
# @lc app=leetcode.cn id=1095 lang=python3
#
# [1095] 山脉数组中查找目标值
#
# https://leetcode.cn/problems/find-in-mountain-array/description/
#
# algorithms
# Hard (37.90%)
# Likes:    192
# Dislikes: 0
# Total Accepted:    29.7K
# Total Submissions: 78.4K
# Testcase Example:  '[1,2,3,4,5,3,1]\n3'
#
# （这是一个 交互式问题 ）
#
# 你可以将一个数组 arr 称为 山脉数组 当且仅当：
#
#
# arr.length >= 3
# 存在一些 0 < i < arr.length - 1 的 i 使得：
#
# arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
# arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
#
#
#
#
# 给定一个山脉数组 mountainArr ，返回 最小 的 index 使得 mountainArr.get(index) ==
# target。如果不存在这样的 index，返回 -1 。
#
# 你无法直接访问山脉数组。你只能使用 MountainArray 接口来访问数组：
#
#
# MountainArray.get(k) 返回数组中下标为 k 的元素（从 0 开始）。
# MountainArray.length() 返回数组的长度。
#
#
# 调用 MountainArray.get 超过 100 次的提交会被判定为错误答案。此外，任何试图绕过在线评测的解决方案都将导致取消资格。
#
#
#
#
#
#
# 示例 1：
#
#
# 输入：array = [1,2,3,4,5,3,1], target = 3
# 输出：2
# 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
#
# 示例 2：
#
#
# 输入：array = [0,1,2,4,2,1], target = 3
# 输出：-1
# 解释：3 在数组中没有出现，返回 -1。
#
#
#
#
# 提示：
#
#
# 3 <= mountain_arr.length() <= 10^4
# 0 <= target <= 10^9
# 0 <= mountain_arr.get(index) <= 10^9
#
#
#

# @lc code=start
# """
# This is MountainArray's API interface.
# You should not implement it, or speculate about its implementation
# """
# class MountainArray:
#    def get(self, index: int) -> int:
#    def length(self) -> int:


class Solution:
    def findInMountainArray(self, target: int, mountain_arr: "MountainArray") -> int:
        # 先找到最大的值所在的下标
        largest = self.findLargest(target, mountain_arr)

        # 查找左半部分，是否有目标值，有的话返回
        left = self.binarySearch(target, mountain_arr, 0, largest)
        if left != -1:
            return left
        
        # 左半部分没找到，再查找右半部分，返回结果
        return self.binarySearch(
            target, mountain_arr, largest + 1, mountain_arr.length() - 1, lambda x: -x
        )

    def binarySearch(
        self, target: int, mountain_arr: "MountainArray", left, right, key=lambda x: x
    ):
        # 在left-right之间进行二分查找
        # 前半部分是生序，后半部分是降序
        # 所以用key使后半部分也变成生序，方便进行二分查找
        target = key(target)
        while left <= right:
            mid = (left + right) // 2
            mid_value = key(mountain_arr.get(mid))
            if mid_value == target:
                return mid
            elif mid_value > target:
                right = mid - 1
            else:
                left = mid + 1

        return -1

    def findLargest(self, target: int, mountain_arr: "MountainArray"):
        # 跟852相同，先找到最大值所在的下标
        left, right, ans = 1, mountain_arr.length() - 2, 0
        while left <= right:
            mid = (left + right) // 2
            mid_value = mountain_arr.get(mid)
            mid1_value = mountain_arr.get(mid + 1)
            if mid_value > mid1_value:
                ans = mid
                right = mid - 1
            else:
                left = mid + 1
        return ans


# @lc code=end
