#
# @lc app=leetcode.cn id=524 lang=python3
#
# [524] 通过删除字母匹配到字典里最长单词
#
# https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/description/
#
# algorithms
# Medium (50.24%)
# Likes:    371
# Dislikes: 0
# Total Accepted:    109.9K
# Total Submissions: 218.5K
# Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
#
# 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s
# 中的某些字符得到。
#
# 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
#
#
#
# 示例 1：
#
#
# 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
# 输出："apple"
#
#
# 示例 2：
#
#
# 输入：s = "abpcplea", dictionary = ["a","b","c"]
# 输出："a"
#
#
#
#
# 提示：
#
#
# 1 <= s.length <= 1000
# 1 <= dictionary.length <= 1000
# 1 <= dictionary[i].length <= 1000
# s 和 dictionary[i] 仅由小写英文字母组成
#
#
#


# @lc code=start
class Solution:
    # 判断s是否是t的子序列
    def isSubStr(self, s: str, t: str) -> bool:
        i, j = 0, 0
        # 分别从头开始遍历
        while i < len(s) and j < len(t):
            # 找到匹配的j++
            if s[i] == t[j]:
                j += 1
            # 不管找没找到，i++
            i += 1
        return j == len(t)

    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        # 先对dictionary进行排序，最长且字母序最小的在前面
        dictionary.sort(key=lambda x: (-len(x), x))
        for target in dictionary:
            # 找到一个符合的子序列，直接返回
            if self.isSubStr(s, target):
                return target
        # 没找到，返回空字符串
        return ""


# @lc code=end
