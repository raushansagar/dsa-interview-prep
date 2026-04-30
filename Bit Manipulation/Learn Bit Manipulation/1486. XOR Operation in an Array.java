/*
    1486. XOR Operation in an Array
    Leetcode Link :- https://leetcode.com/problems/xor-operation-in-an-array/description/
 */


    
// Approch 1
class Solution {
    public int xorOperation(int n, int start) {
        int xor = 0;

        for(int i = 0; i < n; i++){
            xor ^= (start + (2 * i));
        }

        return xor;
    }
}