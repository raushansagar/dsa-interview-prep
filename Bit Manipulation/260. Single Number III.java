/*  
    260. Single Number III
    Leetcode Link :- https://leetcode.com/problems/single-number-iii/description/
 */




// Approch 1
// Total time complexity O(n + n + 32) = O(n)

class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        int xor = 0;

        // O(n)
        for(int val : nums){
            xor ^= val;
        }

        // O(32)
        int shift = 0;
        while(xor != 0){
            if((xor & 1 )== 1){
                break;
            }

            xor = xor >> 1;
            shift++;
        }

        int bitMask = (1 << shift);
        int g1 = 0;
        int g2 = 0;

        // O(n)
        for(int val : nums){
            if((val & bitMask) > 0){
                g1 ^= val;
            }
            else{
                g2 ^= val;
            }
        }

        // Total time complexity O(n + n + 32) = O(n)
        return new int[]{g1, g2};
    }
}