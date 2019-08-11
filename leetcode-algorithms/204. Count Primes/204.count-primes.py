#
# @lc app=leetcode id=204 lang=python3
#
# [204] Count Primes
#
# https://leetcode.com/problems/count-primes/description/
#
# algorithms
# Easy (29.13%)
# Likes:    1106
# Dislikes: 419
# Total Accepted:    245.7K
# Total Submissions: 840.2K
# Testcase Example:  '10'
#
# Count the number of prime numbers less than a non-negative number, n.
#
# Example:
#
#
# Input: 10
# Output: 4
# Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
#
#
#


class Solution:
    def countPrimes(self, n: int) -> int:
        if not n or n == 1:
            return 0
        res = [False]*n
        res[0] = True
        res[1] = True
        i = 0
        while i**2 < n:
            if not res[i]:
                res[i**2:n:i] = [True]*len(res[i**2:n:i])
            i += 1
        return res.count(False)
