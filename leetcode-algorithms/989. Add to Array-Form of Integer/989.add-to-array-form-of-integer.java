/*
 * @lc app=leetcode id=989 lang=java
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
 * For a non-negative integer X, the array-form of X is an array of its digits
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
class Solution {
    int[] sizeTable = new int[] { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999 };

    int stringSize(int x) {
        for (int i = 0;; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = Math.max(A.length, stringSize(K));
        List<Integer> sol = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            sol.add(0);
        }
        for (int i = 1; i < A.length + 1; i++) {
            sol.set(sol.size() - i, A[A.length - i]);
        }
        int plus = (sol.get(sol.size() - 1) + K) / 10;
        sol.set(sol.size() - 1, (sol.get(sol.size() - 1) + K) % 10);
        for (int i = sol.size() - 2; i >= 0; i--) {
            sol.set(i, sol.get(i) + plus);
            plus = sol.get(i) / 10;
            if (plus != 0) {
                sol.set(i, sol.get(i) % 10);
            }
        }
        if (plus != 0) {
            sol.add(0, 1);
        }
        return sol;
    }
}
