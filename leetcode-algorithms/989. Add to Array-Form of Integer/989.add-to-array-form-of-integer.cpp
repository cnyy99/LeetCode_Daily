/*
 * @lc app=leetcode id=989 lang=cpp
 *
 * [989] Add to Array-Form of Integer
 *
 * https://leetcode.com/problems/add-to-array-form-of-integer/description/
 *
 * algorithms
 * Easy (44.85%)
 * Total Accepted:    12.6K
 * Total Submissions: 28.1K
 * Testcase Example:  '[1,2,0,0]\n34'
 *
 * For a non-negative integer X, the array-form of X is an array of its A
 * in left to right order.  For example, if X = 1231, then the array form is
 * [1,2,3,1].
 * 
 * Given the array-form A of a non-negative integer X, return the array-form of
 * the integer X+K.
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
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * 
 * 
 * 
 * 
 * Note：
 * 
 * 
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 * 
 * 
 * 
 * 
 * 
 */
class Solution
{
public:
    int sizeTable[9] = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999};

    int stringSize(int x)
    {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }
    vector<int> addToArrayForm(vector<int> &A, int K)
    {
        vector<int> sol(max((int)A.size(), stringSize(K)), 0);
        for (int i = 1; i < A.size() + 1; i++)
        {
            sol[sol.size() - i] = A[A.size() - i];
        }
        int plus = (sol[sol.size() - 1] + K) / 10;
        sol[sol.size() - 1] = (sol[sol.size() - 1] + K) % 10;
        for (int i = sol.size() - 2; i >= 0; i--)
        {
            sol[i] += plus;
            plus = sol[i] / 10;
            if (plus != 0)
            {
                sol[i] %= 10;
            }
        }
        if (plus)
        {
            sol.insert(sol.begin(), 1);
        }
        return sol;
    }
};
