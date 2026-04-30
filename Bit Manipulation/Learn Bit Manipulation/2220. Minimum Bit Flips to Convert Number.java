/* 
    2220. Minimum Bit Flips to Convert Number
    Leetcode Link :- https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
 */



// approch 1
// time compelxit O(log n) n = max of start and goal

class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;

        while(start > 0 || goal > 0){
            int bitA = start & 1;
            int bitB = goal & 1;

            count += bitA ^ bitB;

            start = start >> 1;
            goal = goal >> 1;
        }

        return count;
    }
}