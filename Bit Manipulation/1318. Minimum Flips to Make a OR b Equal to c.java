/*  
    1318. Minimum Flips to Make a OR b Equal to c
    Leetcode Link :- https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
 */


// Approch 1 
// Time complexity O(log n) n is max of a , b , c

class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;

        while(c > 0 || a > 0 || b > 0){
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if(bitC == 1){
                count += (bitA | bitB) == 0 ? 1 : 0;
            }
            else{
                count += (bitA & bitB) == 1 ? 2 : bitA | bitB;
            }

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }


        return count;
    }
}