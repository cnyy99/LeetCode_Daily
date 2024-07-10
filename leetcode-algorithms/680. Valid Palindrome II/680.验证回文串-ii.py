#
# @lc app=leetcode.cn id=680 lang=python3
#
# [680] 验证回文串 II
#
# https://leetcode.cn/problems/valid-palindrome-ii/description/
#
# algorithms
# Easy (40.19%)
# Likes:    645
# Dislikes: 0
# Total Accepted:    151.3K
# Total Submissions: 375.7K
# Testcase Example:  '"aba"'
#
# 给你一个字符串 s，最多 可以从中删除一个字符。
# 
# 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s = "aba"
# 输出：true
# 
# 
# 示例 2：
# 
# 
# 输入：s = "abca"
# 输出：true
# 解释：你可以删除字符 'c' 。
# 
# 
# 示例 3：
# 
# 
# 输入：s = "abc"
# 输出：false
# 
# 
# 
# 提示：
# 
# 
# 1 <= s.length <= 10^5
# s 由小写英文字母组成
# 
# 
#

# @lc code=start
class Solution:

    def validPalindrome(self, s: str) -> bool:
        # 左端和右端
        start, end = 0, len(s) - 1
        # 分别从头和尾遍历，看首尾是否相同
        while start < end:
            # 相同的话往中间移动
            if s[start] == s[end]:
                start += 1
                end -= 1
            else:
                # 不同的话分别排除左侧字符和右侧字符，再检测一次，有符合的就返回True
                return self.valid(s[start:end]) or self.valid(s[start + 1:end + 1])
        return True

    def valid(self, s: str) -> bool:
        # 使用语法糖是否是回文字符串
        return s==s[::-1]
        
        # 自己检查是否是回文字符串
        # start, end = 0, len(s) - 1
        # while start < end:
        #     if s[start] == s[end]:
        #         start += 1
        #         end -= 1
        #     else:
        #         return False
        # return True
# @lc code=end

