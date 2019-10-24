/*
 * @lc app=leetcode id=242 lang=cpp
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (52.42%)
 * Likes:    747
 * Dislikes: 111
 * Total Accepted:    356.2K
 * Total Submissions: 676.9K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */
class Solution
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.length() != t.length())
        {
            return false;
        }
        int map[26];
        memset(map, 0, sizeof(int) * 26);
        for (int i = 0; i < s.length(); i++)
        {
            map[s[i] - 'a']++;
            map[t[i] - 'a']--;
        }
        for (auto c : map)
        {
            if (c)
            {
                return false;
            }
        }
        return true;
        // sort(s.begin(), s.end());
        // sort(t.begin(), t.end());
        // return s == t;
    }
};
