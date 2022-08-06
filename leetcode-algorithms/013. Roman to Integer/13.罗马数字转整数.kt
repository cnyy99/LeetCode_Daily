/*
 * @lc app=leetcode.cn id=13 lang=kotlin
 *
 * [13] 罗马数字转整数
 *
 * https://leetcode.cn/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (62.47%)
 * Likes:    1990
 * Dislikes: 0
 * Total Accepted:    680.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '"III"'
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 
 * 
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V
 * + II 。
 * 
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数
 * 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * 
 * 
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 
 * 
 * 给定一个罗马数字，将其转换成整数。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "III"
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "IV"
 * 输出: 4
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "IX"
 * 输出: 9
 * 
 * 示例 4:
 * 
 * 
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 
 * 
 * 示例 5:
 * 
 * 
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * 
 * 
 */

// @lc code=start
class Solution {
    companion object {
        // 定义罗马字母对应的数字，从大到小
        val numbers = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        // 定义罗马数字，从大到小
        val exp = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    }

    fun romanToInt(s: String): Int {
        // 当前进行比较的罗马数字的下标
        var index = 0
        // 存储结果
        var result = 0
        // 当前处理的罗马数字的起始下标
        var charIndex = 0
        // 从大到小遍历所有罗马字母exp
        while (index < exp.size) {
            // 比较s中当前罗马字母和exp中当前罗马字母是否相同
            if (isEqual(s, charIndex, index)) {
                // 相同时，处理的s的下标增加当前罗马数字的长度（1/2）
                charIndex += exp[index].length
                // 相同时，结果中增加该罗马数字对应的数值
                result += numbers[index]
            } else {
                // 不相同时，处理更小的exp下一位罗马数字
                index++
            }
        }
        // 返回结果
        return result
    }

    private fun isEqual(s: String, charIndex: Int, index: Int): Boolean {
        // 根据当前进行比较的exp罗马数字的长度计算s的结束下标
        val endIndex = charIndex + exp[index].length
        // 超过s的长度，返回false
        if (endIndex > s.length) {
            return false
        }
        // 根据exp[index].length判断比较相同的位数
        return when (exp[index].length) {
            1 -> s[charIndex] == exp[index][0]
            2 -> s[charIndex] == exp[index][0] && s[charIndex + 1] == exp[index][1]
            else -> false
        }
    }
}
// @lc code=end

