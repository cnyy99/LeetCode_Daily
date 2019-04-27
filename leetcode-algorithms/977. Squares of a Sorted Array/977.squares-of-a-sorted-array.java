/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (72.86%)
 * Total Accepted:    56.2K
 * Total Submissions: 77.7K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 * 
 * 
 * 
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        int left = 0, right = A.length - 1;
        int[] sol = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                sol[i] = A[left] * A[left++];
            } else {
                sol[i] = A[right] * A[right--];
            }
        }
        return sol;
    }
}
