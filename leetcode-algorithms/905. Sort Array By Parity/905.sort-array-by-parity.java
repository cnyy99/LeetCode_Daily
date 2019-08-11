/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 *
 * https://leetcode.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (72.13%)
 * Total Accepted:    85.5K
 * Total Submissions: 118K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 * 
 * 
 */
class Solution {
    public int[] sortArrayByParity(int[] A) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (Integer t : A) {
            if (t % 2 == 0) {
                a.add(t);
            } else {
                b.add(t);
            }
        }
        a.addAll(b);
        Integer[] c = a.toArray(new Integer[A.length]);
        int[] d = new int[c.length];
        int i = 0;
        for (Integer t : c) {
            d[i++] = t;
        }
        return d;
    }
}
