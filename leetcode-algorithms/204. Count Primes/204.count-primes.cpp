/*
 * @lc app=leetcode id=204 lang=cpp
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.13%)
 * Likes:    1106
 * Dislikes: 419
 * Total Accepted:    245.7K
 * Total Submissions: 840.2K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
class Solution
{
public:
    int countPrimes(int n)
    {
        if (!n || n == 1)
        {
            return 0;
        }
        vector<bool> res(n, true);
        res[0] = false;
        res[1] = false;
        for (int i = 0; i * i < n; i++)
        {
            if (res[i])
            {
                for (int j = i * i; j < n; j += i)
                {
                    res[j] = false;
                }
            }
        }
        return count(res.begin(), res.end(), true);
    }
};
