/*
 * @lc app=leetcode id=14 lang=cpp
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.98%)
 * Likes:    1588
 * Dislikes: 1451
 * Total Accepted:    534.7K
 * Total Submissions: 1.6M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {
        if (strs.empty())
        {
            return "";
        }
        string res = strs[0];
        for (auto str : strs)
        {
            res = find(res, str);
            if (res == "")
            {
                break;
            }
        }
        return res;
    }
    string find(const string &left, const string &right)
    {
        int size = min(left.size(), right.size()), i = 0;
        for (; i < size; i++)
        {
            if (left[i] != right[i])
            {
                break;
            }
        }
        return left.substr(0, i);
    }
};
