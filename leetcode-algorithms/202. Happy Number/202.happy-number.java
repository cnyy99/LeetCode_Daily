/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (44.35%)
 * Likes:    825
 * Dislikes: 201
 * Total Accepted:    228K
 * Total Submissions: 507K
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 
 * 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 */
class Solution {
    int getNumSum(int n){
        int ans = 0;
        while(n!=0){
            ans += Math.pow(n%10, 2);
			n/=10;
        }
        return ans;
    }
    public boolean isHappy(int n) {
        boolean[] rep = new boolean[1000];
        for (int i = 0; i < 1000; i++)
        {
            rep[i] = false;
        }
		n = getNumSum(n);
        while(!rep[n]){
			rep[n] = true;
            if(n == 1)
                return true;
			n = getNumSum(n);
        }
        return false;
    }
}

