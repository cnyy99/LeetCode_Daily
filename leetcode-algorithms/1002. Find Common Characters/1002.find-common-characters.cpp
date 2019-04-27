/*
 * @lc app=leetcode id=1002 lang=cpp
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
public:
    vector<string> commonChars(vector<string>& A) {
        vector<int>charcount(26,0);
        for(auto i=0;i<A[0].length();i++)
        {
            charcount[A[0][i]-'a']++;
        }
        for(auto i=1;i<A.size();i++)
        {
            vector<int>tempcount(26,0);
            for(char t:A[i])
            {
                tempcount[t-'a']++;
            }
            for(auto j=0;j<26;j++)
            {
                charcount[j]=min(charcount[j],tempcount[j]);
            }
        }
        vector<string>sol;
        for(auto i=0;i<26;i++)
        {
            for(auto j=0;j<charcount[i];j++)
            {
                char temp='a'+i;
                string tempp=string(1,temp);
                sol.push_back(tempp);
            }
        }
        return sol;
    }
};

