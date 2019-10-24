/*
 * @lc app=leetcode id=67 lang=cpp
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (39.39%)
 * Likes:    987
 * Dislikes: 198
 * Total Accepted:    309.7K
 * Total Submissions: 785.9K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their res (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution
{
public:
    string addBinary(string a, string b)
    {
        string res;
        int plus = 0;
        int i = a.size() - 1, j = b.size() - 1;
        while (i >= 0 || j >= 0 || plus > 0)
        {
            if (i >= 0)
            {
                plus += a[i] - '0';
                i -= 1;
            }
            if (j >= 0)
            {
                plus += b[j] - '0';
                j -= 1;
            }
            res += (plus % 2) + '0';
            plus /= 2;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
