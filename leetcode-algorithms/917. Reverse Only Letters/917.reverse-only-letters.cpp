/*
 * @lc app=leetcode id=917 lang=cpp
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
class Solution
{
public:
    string reverseOnlyLetters(string S)
    {
        // string newS = "";
        // string letters="";
        // for(auto ch:S)
        // {
        //     if(isalpha(ch))
        //     {
        //         letters += ch;
        //         newS += " ";
        //     }else
        //     {
        //         newS += ch;
        //     }
        // }
        // reverse(letters.begin(),letters.end());
        // for (int i = 0,j=0; i < S.size();i++)
        // {
        //     if(newS[i]!=' ')
        //     {
        //         continue;
        //     }else{
        //         newS[i] = letters[j++];
        //     }
        // }
        // return newS;
        int i = 0;
        int j = S.size() - 1;
        while (i < j)
        {
            if (!isalpha(S[i]))
            {
                i++;
            }
            else if (!isalpha(S[j]))
            {
                j--;
            }
            else
            {
                swap(S[i], S[j]);
                i++;
                j--;
            }
        }
        return S;
    }
};
