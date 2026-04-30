/*
    2997. Minimum Number of Operations to Make Array XOR Equal to K
    Leetcode Link :- https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/
 */





// Approch 1
// Time complexity O(k) k = no of bit O(1)

class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;

        for(int val : nums){
            xor ^= val;
        }

        int minOp = 0;
        while(xor != 0 || k != 0){
            if((xor & 1) != (k & 1)) minOp++;

            xor = xor >> 1;
            k = k >> 1;
        }

        return minOp;
    }
}