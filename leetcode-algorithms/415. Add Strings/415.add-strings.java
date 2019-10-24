/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (44.31%)
 * Likes:    468
 * Dislikes: 158
 * Total Accepted:    108.4K
 * Total Submissions: 244.7K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        StringBuilder res = new StringBuilder(num1);
        int plus = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (j >= 0) {
            int numOf2 = num1.charAt(i) - '0' + num2.charAt(j) - '0' + plus;
            res.setCharAt(i, (char) (numOf2 % 10 + '0'));
            plus = numOf2 / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            res.setCharAt(i, (char) ((num1.charAt(i) - '0' + plus) % 10 + '0'));
            plus = (num1.charAt(i) - '0' + plus) / 10;
            i--;
        }
        if (plus != 0) {
            return "1" + res.toString();
        }
        return res.toString();
    }
}
