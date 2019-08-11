/*
 * @lc app=leetcode id=20 lang=cpp
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (35.96%)
 * Likes:    2805
 * Dislikes: 138
 * Total Accepted:    570.4K
 * Total Submissions: 1.6M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution
{
public:
    bool isValid(string s)
    {
        stack<char> sol;
        if (s.length() % 2 != 0)
            return false;
        map<char, char> m;
        m['['] = ']';
        m['{'] = '}';
        m['('] = ')';
        for (int i = 0; i < s.length(); i++)
        {
            switch (s[i])
            {
            case '[':
            case '{':
            case '(':
                sol.push(s[i]);
                break;
            case ']':
            case ')':
            case '}':
                if (sol.size() == 0)
                {
                    return false;
                }
                if (s[i] == m[sol.top()])
                {
                    sol.pop();
                }
                break;
            }
        }
        return sol.size() == 0;
    }
};
