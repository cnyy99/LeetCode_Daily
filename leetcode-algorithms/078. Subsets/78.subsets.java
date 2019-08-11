/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (51.15%)
 * Total Accepted:    354K
 * Total Submissions: 677.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        sol.add(new ArrayList<>());
        for (int n : nums) {
            int size = sol.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(sol.get(i));
                subset.add(n);
                sol.add(subset);
            }
        }
        return sol;
    }
}
