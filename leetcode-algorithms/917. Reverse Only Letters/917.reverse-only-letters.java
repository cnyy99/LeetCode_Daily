/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (55.96%)
 * Likes:    271
 * Dislikes: 26
 * Total Accepted:    29.7K
 * Total Submissions: 53.1K
 * Testcase Example:  '"ab-cd"'
 *
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their
 * positions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "ab-cd"
 * Output: "dc-ba"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(S);
        while (i < j) {
            if (!Character.isLetter(S.charAt(i))) {
                i++;
            } else if (!Character.isLetter(S.charAt(j))) {
                j--;
            } else {
                stringBuilder.setCharAt(i, S.charAt(j));
                stringBuilder.setCharAt(j, S.charAt(i));
                i++;
                j--;
            }
        }
        return stringBuilder.toString();
    }
}
