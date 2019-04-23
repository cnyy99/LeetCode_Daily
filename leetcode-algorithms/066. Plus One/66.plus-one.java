/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.72%)
 * Total Accepted:    372.5K
 * Total Submissions: 909.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1 && digits[0] == 0)
		{
			digits[0] = 1;
			return digits;
		}
		int plus = (digits[digits.length - 1] + 1) / 10;
		digits[digits.length - 1] += 1;
		digits[digits.length - 1] %= 10;
		for (int i = digits.length - 2; i >= 0; i--)
		{
			//int &temp = digits[i];
			digits[i] += plus;
			plus = digits[i] / 10;
			if (plus == 0)
			{
				break;
			}
			else
			{
				digits[i] = 0;
			}
		}
		if (plus==1)
		{
            int []sol=new int[digits.length+1];
            System.arraycopy(digits,0,sol,1,digits.length);
			sol[0]=1;
            return sol;
		}
		return digits;
    }
}

