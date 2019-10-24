/*
 * @lc app=leetcode id=415 lang=cpp
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (44.31%)
 * Likes:    466
 * Dislikes: 158
 * Total Accepted:    108.3K
 * Total Submissions: 244.4K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution
{
public:
    string addStrings(string num1, string num2)
    {
        if (num1.size() < num2.size())
        {
            return addStrings(num2, num1);
        }
        string res = num1;
        int plus = 0, i = num1.size() - 1, j = num2.size() - 1;
        while (j >= 0)
        {
            int temp = num1[i] - '0' + num2[j] - '0' + plus;
            res[i] = temp % 10 + '0';
            plus = temp / 10;
            i--, j--;
        }
        while (i >= 0)
        {
            res[i] = (num1[i] - '0' + plus) % 10 + '0';
            plus = (num1[i] - '0' + plus) / 10;
            i--;
        }
        if (plus)
        {
            res = "1" + res;
        }
        return res;
    }
};
