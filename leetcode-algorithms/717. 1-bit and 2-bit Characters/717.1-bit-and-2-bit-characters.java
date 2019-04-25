/*
 * @lc app=leetcode id=717 lang=java
 *
 * [717] 1-bit and 2-bit Characters
 *
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 *
 * algorithms
 * Easy (48.89%)
 * Total Accepted:    39K
 * Total Submissions: 79.3K
 * Testcase Example:  '[1,0,0]'
 *
 * We have two special characters. The first character can be represented by
 * one bit 0. The second character can be represented by two bits (10 or
 * 11).  
 * 
 * Now given a string represented by several bits. Return whether the last
 * character must be a one-bit character or not. The given string will always
 * end with a zero.
 * 
 * Example 1:
 * 
 * Input: 
 * bits = [1, 0, 0]
 * Output: True
 * Explanation: 
 * The only way to decode it is two-bit character and one-bit character. So the
 * last character is one-bit character.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation: 
 * The only way to decode it is two-bit character and two-bit character. So the
 * last character is NOT one-bit character.
 * 
 * 
 * 
 * Note:
 * 1 .
 * bits[i] is always 0 or 1.
 * 
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0;i<bits.length;)
        {
            if(bits[i]==1)
            {
                i+=2;
                if(i==bits.length)
                    return false;
            }
            else
            {
                if(++i==bits.length)
                    return true;
            }
        }
        return false;
    }
}

