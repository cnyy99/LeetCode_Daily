/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.17%)
 * Total Accepted:    651.5K
 * Total Submissions: 2.6M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        boolean t = true;
        long newx = x;
        if(newx<0)
        {
            newx=-newx;
            t= false;
        }
        long n=0;
        if(0<=newx&&newx<10)
        {
            if(t)
                return (int)newx;
            else
                return (int)-newx;
        }
        while(newx>0)
        {
            n=newx%10+(n*10);
            if(n>Integer.MAX_VALUE&&t)
            {
                return 0;
            }
            if(-n<Integer.MIN_VALUE&&!t)
            {
                return 0;
            }
    //        std::cout<<old<<"\t"<<n<<std::endl;
            newx=newx/10;
        }
        if(t)
            return (int)n;
        else
            return (int)-n;
    
    }
}

