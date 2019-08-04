/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 *
 * https://leetcode.com/problems/custom-sort-string/description/
 *
 * algorithms
 * Medium (62.21%)
 * Likes:    424
 * Dislikes: 134
 * Total Accepted:    37.9K
 * Total Submissions: 60.4K
 * Testcase Example:  '"cba"\n"abcd"'
 *
 * S and T are strings composed of lowercase letters. In S, no letter occurs
 * more than once.
 * 
 * S was sorted in some custom order previously. We want to permute the
 * characters of T so that they match the order that S was sorted. More
 * specifically, if x occurs before y in S, then x should occur before y in the
 * returned string.
 * 
 * Return any permutation of T (as a string) that satisfies this property.
 * 
 * 
 * Example :
 * Input: 
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation: 
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b",
 * and "a". 
 * Since "d" does not appear in S, it can be at any position in T. "dcba",
 * "cdba", "cbda" are also valid outputs.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 * 
 * 
 */
class Solution {
    public String customSortString(String S, String T) {
        Set<Character> sset=new HashSet<>();
        StringBuilder st = new StringBuilder("");
        int[]tmap=new int[26];
        Arrays.fill(tmap, 0);
        char[] sCharArray = S.toCharArray();
        for (Character ch : sCharArray)
        {
            sset.add(ch);
        }
        for (Character ch : T.toCharArray())
        {
            tmap[ch-'a']++;
            if (!sset.contains(ch))
            {
                st .append(ch);
            }
        }
        for (Character ch : sCharArray)
        {
            for (int i = 0; i < tmap[ch-'a']; i++)
            {
                st .append(ch);
            }
        }
        return st.toString();
    }
}
