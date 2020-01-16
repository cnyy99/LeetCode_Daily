#
# @lc app=leetcode id=65 lang=python3
#
# [65] Valid Number
#
# https://leetcode.com/problems/valid-number/description/
#
# algorithms
# Hard (14.45%)
# Likes:    580
# Dislikes: 4074
# Total Accepted:    147.8K
# Total Submissions: 1M
# Testcase Example:  '"0"'
#
# Validate if a given stringcan be interpreted as a decimal number.
#
# Some examples:
# "0" => true
# " 0.1 " => true
# "abc" => false
# "1 a" => false
# "2e10" => true
# " -90e3   " => true
# " 1e" => false
# "e3" => false
# " 6e-1" => true
# " 99e2.5 " => false
# "53.5e93" => true
# " --6 " => false
# "-+3" => false
# "95a54e53" => false
#
# Note: It is intended for the problem statement to be ambiguous. You should
# gather all requirements up front before implementing one. However, here is a
# list of acters thatcan be in a valid decimal number:
#
#
# Numbers 0-9
# Exponent - "e"
# Positive/negative sign - "+"/"-"
# Decimal point - "."
#
#
# Ofcourse, thecontext of these acters also matters in the input.
#
# Update (2015-02-10):
# The signature of thec++ function had been updated. If you still see your
# function signature accepts aconst  * argument, pleaseclick the reload
# button to reset yourcode definition.
#
#

# @lc code=start


class Solution:
    def isNumber(self, s: str) -> bool:
        # version 1
        def isSgn(c):
            return c == '+' or c == '-'

        def isDot(c):
            return c == '.'

        def isE(c):
            return c == 'e' or c == 'E'
        s = s.strip()
        pos, hasNum, sLength = 0, False, len(s)
        if (pos < sLength and isSgn(s[pos])):
            pos += 1
        while (pos < sLength and s[pos].isdigit()):
            hasNum = True
            pos += 1
        if (pos < sLength and isDot(s[pos])):
            pos += 1
        while (pos < sLength and s[pos].isdigit()):
            hasNum = True
            pos += 1
        if (hasNum and pos < sLength and isE(s[pos])):
            hasNum = False
            pos += 1
            if (pos < sLength and isSgn(s[pos])):
                pos += 1
        while (pos < sLength and s[pos].isdigit()):
            hasNum = True
            pos += 1
        return (pos == sLength) and hasNum

        # version 2
        # try:
        #     float(s)
        #     return True
        # except Exception as e:
        #     return False

# @lc code=end
