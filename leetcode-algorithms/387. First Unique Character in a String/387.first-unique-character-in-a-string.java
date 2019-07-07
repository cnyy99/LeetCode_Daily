/*
 * @lc app=leetcode id=387 lang=java
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
    public int firstUniqChar(String s) {
        int[] result = new int[26];
        Arrays.fill(result, 0);
        for(char t:s.toCharArray())
        {
            result[t-'a']++;
        }
        for (int i = 0; i < s.length();i++)
        {
            if(result[s.charAt(i)-'a']==1)
            {
                return i;
            }
        }
        return -1;
    }
}
