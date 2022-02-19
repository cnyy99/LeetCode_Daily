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
        // 存储公共前缀
        val prefix = StringBuilder() 
        // 遍历的下标
        var index = 0
        while (true) {
            // 标记是否第一次遍历到当前下标
            var first = true
            for (s in strs) {
                if (s.lastIndex < index) {
                    // 某个字符串已经遍历完了，返回结果
                    // 根据是否是第一次遍历到当前下标有不同
                    return if (first) prefix.toString() else prefix.substring(0, prefix.lastIndex)
                }
                if (first) {
                    // 第一次遍历到当前下标，直接添加当前字符到prefix
                    prefix.append(s[index])
                    first = false
                    continue
                }
                if (s[index] != prefix[prefix.lastIndex]) {
                    // 字符不同时返回最后结果
                    return prefix.substring(0, prefix.lastIndex)
                }
            }
            index++
        }
    }
}
// @lc code=end

