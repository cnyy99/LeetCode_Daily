/*
 * @lc app=leetcode id=75 lang=cpp
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (41.39%)
 * Likes:    1554
 * Dislikes: 148
 * Total Accepted:    311.4K
 * Total Submissions: 742.2K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */
class Solution
{
public:
    void sortColors(vector<int> &nums)
    {
        //     int a = 0, b = 0, c = 0;
        //     for (auto t : nums)
        //     {
        //         switch (t)
        //         {
        //         case 0:
        //             a++;
        //             break;
        //         case 1:
        //             b++;
        //             break;
        //         case 2:
        //             c++;
        //             break;
        //         default:
        //             break;
        //         }
        //     }
        //     int i = 0;
        //     while (a--)
        //     {
        //         nums[i++] = 0;
        //     }
        //     while (b--)
        //     {
        //         nums[i++] = 1;
        //     }
        //     while (c--)
        //     {
        //         nums[i++] = 2;
        //     }
        // }
        int i = 0, j = i, k = nums.size() - 1;
        while (j <= k)
        {
            if (nums[j] == 0)
                swap(nums[i++], nums[j++]);
            else if (nums[j] == 1)
                j++;
            else
                swap(nums[k--], nums[j]);
        }
    }
};
