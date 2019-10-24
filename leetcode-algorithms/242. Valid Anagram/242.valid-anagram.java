import java.util.Arrays;

/*
 * @lc app=leetcode id=242 lang=java
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
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        int[]=new map[26];
        Arrays.fill(map, 0);
        for (int i = 0; i < s.length();i++)
        {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for(int t:map)
        {
            if(t!=0)
            {
                return false;
            }
        }
        return true;
        // char[] tempArray1=s.toCharArray();
        // char[] tempArray2=t.toCharArray();
        // Arrays.sort(tempArray1);
        // Arrays.sort(tempArray2);
        // return String.valueOf(tempArray1).equals(String.valueOf(tempArray2));
    }
}
