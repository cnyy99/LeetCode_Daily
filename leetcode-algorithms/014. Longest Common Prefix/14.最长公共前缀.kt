/*
 * @lc app=leetcode.cn id=14 lang=kotlin
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (41.61%)
 * Likes:    2028
 * Dislikes: 0
 * Total Accepted:    727.3K
 * Total Submissions: 1.7M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val prefix = StringBuilder()
        var index = 0
        while (true) {
            var first = true
            for (s in strs) {
                if (s.lastIndex < index) {
                    // 当前字符串总长度小于 公共前缀长度时，返回结果
                    return if (first) prefix.toString() else prefix.substring(0, prefix.lastIndex)
                }
                if (first) {
                    // 第一次遍历到这个index时，直接添加
                    prefix.append(s[index])
                    first = false
                    continue
                }
                if (s[index] != prefix[prefix.lastIndex]) {
                    // 当前字符串index字符与公共前缀不同时，返回结果
                    return prefix.substring(0, prefix.lastIndex)
                }
            }
            index++
        }
    }
}
// @lc code=end

