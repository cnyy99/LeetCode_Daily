#
# @lc app=leetcode.cn id=435 lang=python3
#
# [435] 无重叠区间
#
# https://leetcode.cn/problems/non-overlapping-intervals/description/
#
# algorithms
# Medium (51.51%)
# Likes:    1138
# Dislikes: 0
# Total Accepted:    283.3K
# Total Submissions: 545.9K
# Testcase Example:  '[[1,2],[2,3],[3,4],[1,3]]'
#
# 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回
# 需要移除区间的最小数量，使剩余区间互不重叠 。
#
#
#
# 示例 1:
#
#
# 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
# 输出: 1
# 解释: 移除 [1,3] 后，剩下的区间没有重叠。
#
#
# 示例 2:
#
#
# 输入: intervals = [ [1,2], [1,2], [1,2] ]
# 输出: 2
# 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
#
#
# 示例 3:
#
#
# 输入: intervals = [ [1,2], [2,3] ]
# 输出: 0
# 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
#
#
#
#
# 提示:
#
#
# 1 <= intervals.length <= 10^5
# intervals[i].length == 2
# -5 * 10^4 <= starti < endi <= 5 * 10^4
#
#
#


# @lc code=start
class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        # 根据右端点进行排序
        intervals.sort(key=lambda x: (x[1], x[0]))
        # 记录重叠的区间数
        count = 0
        # 记录要比较的左区间和右区间
        i, j = 0, 1
        while j < len(intervals):
            # 判断是否重叠
            if self.vaild(intervals[i], intervals[j]):
                # 不重叠的话，更新左区间为当前的右区间
                # 右区间往右移动
                i = j
                j += 1
            else:
                # 重叠的话，count+1
                # 右区间往右移动
                count += 1
                j += 1
        return count

    def vaild(self, left, right):
        # 判断区间是否重叠，left[1] <= right[0]时不重叠
        return left[1] <= right[0]


# @lc code=end
