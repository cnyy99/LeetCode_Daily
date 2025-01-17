#
# @lc app=leetcode.cn id=81 lang=python3
#
# [81] 搜索旋转排序数组 II
#
# https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/description/
#
# algorithms
# Medium (41.07%)
# Likes:    786
# Dislikes: 0
# Total Accepted:    228.3K
# Total Submissions: 555.9K
# Testcase Example:  '[2,5,6,0,0,1,2]\n0'
#
# 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
#
# 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k],
# nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始
# 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
#
# 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值
# target ，则返回 true ，否则返回 false 。
#
# 你必须尽可能减少整个操作步骤。
#
#
#
# 示例 1：
#
#
# 输入：nums = [2,5,6,0,0,1,2], target = 0
# 输出：true
#
#
# 示例 2：
#
#
# 输入：nums = [2,5,6,0,0,1,2], target = 3
# 输出：false
#
#
#
# 提示：
#
#
# 1 <= nums.length <= 5000
# -10^4 <= nums[i] <= 10^4
# 题目数据保证 nums 在预先未知的某个下标上进行了旋转
# -10^4 <= target <= 10^4
#
#
#
#
# 进阶：
#
#
# 此题与 搜索旋转排序数组 相似，但本题中的 nums  可能包含 重复 元素。这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
#
#
#
#
#


# @lc code=start
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                # 代表找到了
                return True

            # 中间值大于左侧值时，有两种可能
            if nums[mid] > nums[left]:
                if nums[mid] > target >= nums[left]:
                    # 此时 目标值在[left, mid-1]中
                    right = mid - 1
                else:
                    # 此时 目标值在[mid+1, right]中
                    left = mid + 1
            elif nums[mid] == nums[left]:
                # 无法确定目标值的位置  如 1，0，1，1，1，1
                # 所以目标值可能出现的范围为[left+1, right]
                left += 1
            else:
                # nums[mid] < nums[left] 时
                if nums[mid] < target <= nums[right]:
                    # 此时 目标值在[mid+1, right]中
                    left = mid + 1
                else:
                    # 此时 目标值在[left, mid-1]中
                    right = mid - 1
        return False


# @lc code=end
