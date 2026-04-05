/* 
    1611. Minimum One Bit Operations to Make Integers Zero
    Leetcode Link :- https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/
*/


// Approch 1
// Time compelxity O(1)

class Solution {
    public int minimumOneBitOperations(int n) {
        int[] F = new int[32];
        F[0] = 1;

        for(int i = 1; i <= 31; i++){
            F[i] = 2 * F[i-1] + 1;
        }

        int sign = 1;
        int result = 0;

        for(int i = 30; i >= 0; i--){
            int ith_bit = ((1 << i) & n);

            if(ith_bit == 0) continue;

            if(sign > 0){
                result += F[i];
            }
            else{
                result -= F[i];
            }

            sign = -sign;
        }


        return result;
    }
}