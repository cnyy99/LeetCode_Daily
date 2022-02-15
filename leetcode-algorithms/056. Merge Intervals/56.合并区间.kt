/*
 * @lc app=leetcode.cn id=56 lang=kotlin
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (47.66%)
 * Likes:    1311
 * Dislikes: 0
 * Total Accepted:    367.2K
 * Total Submissions: 766.9K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) {
            return intervals
        }
        intervals.sortBy {
            // 根据区间的开始位置进行排序
            it[0]
        }
        // Arrays.sort(intervals) { o1, o2 -> o1[0] - o2[0] }
        val result = ArrayList<IntArray>()
        // 将第一个区间加入结果中
        result.add(intervals[0])
        // 依次合并剩下的区间
        for (i in 1 until intervals.size) {
            if (result[result.size - 1][1] >= intervals[i][0]) {
                // 结果中最后一个区间的结束位置大于下一个区间的开始位置时，合并这两个区间为较大的一个
                result[result.size - 1][1] = result[result.size - 1][1].coerceAtLeast(intervals[i][1])
            } else {
                // 或者直接添加该区间
                result.add(intervals[i])
            }
        }
        // 转为数组
        return result.toTypedArray()
    }
}
// @lc code=end

