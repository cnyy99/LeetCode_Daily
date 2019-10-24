/*
 * @lc app=leetcode id=58 lang=cpp
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.26%)
 * Likes:    380
 * Dislikes: 1594
 * Total Accepted:    273.2K
 * Total Submissions: 847K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 * 
 * 
 */
class Solution
{
public:
    int lengthOfLastWord(string s)
    {
        int len = 0, tail = s.length();
        while (tail >= 0 && s[tail--] == ' ')
            ;
        while (tail >= 0 && s[tail--] != ' ' && ++len)
            ;
        return len;
    }
};
