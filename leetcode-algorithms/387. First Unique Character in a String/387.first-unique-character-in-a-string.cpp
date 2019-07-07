/*
 * @lc app=leetcode id=387 lang=cpp
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (50.17%)
 * Likes:    1055
 * Dislikes: 80
 * Total Accepted:    283.3K
 * Total Submissions: 563.2K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
class Solution {
public:
    int firstUniqChar(string s) {
        int result[26];
        memset(result, 0, sizeof(int)*26);
        for(auto t:s)
        {
            result[t-'a']++;
        }
        for (int i = 0; i < s.length();i++)
        {
            if(result[s[i]-'a']==1)
            {
                return i;
            }
        }
        return -1;
    }
};
