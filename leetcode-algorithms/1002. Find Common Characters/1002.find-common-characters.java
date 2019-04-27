/*
 * @lc app=leetcode id=1002 lang=java
 *
 * [1002] Find Common Characters
 *
 * https://leetcode.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (69.05%)
 * Total Accepted:    17.1K
 * Total Submissions: 25.9K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates).  For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 * 
 * 
 * 
 */
class Solution {
    public List<String> commonChars(String[] A) {
        int[]charcount =new int[26];
        for(char t:A[0].toCharArray())
        {
            charcount[t-'a']++;
        }
        for(int i=1;i<A.length;i++)
        {
            int[]tempcount =new int[26];
            for(char t:A[i].toCharArray())
            {
                tempcount[t-'a']++;
            }
            for(int j=0;j<26;j++)
            {
                charcount[j]=Math.min(charcount[j],tempcount[j]);
            }
        }
        List<String>sol=new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<charcount[i];j++)
            {
                sol.add((char)('a'+i)+"");
            }
        }
        return sol;
    }
}

