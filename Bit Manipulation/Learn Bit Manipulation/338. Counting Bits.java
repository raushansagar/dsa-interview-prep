/*  
    338. Counting Bits
    Leetcode Link :- https://leetcode.com/problems/counting-bits/description/
 */


// Approch 1
// Time complexity O(n * log n)

class Solution1{
    private int calBinaryOnes(int n){
        int count = 0;

        while(n > 0){
            count += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
        }

        return count;
    }
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        
        for(int i = 0; i <= n; i++){
            result[i] = calBinaryOnes(i);
        }

        return result;
    }
}




// Approch 2
// Time complexity O(n)

class Solution2{
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i = 1; i <= n; i++){
            result[i] = result[i/2] + (i%2 == 1 ? 1 : 0);
        }

        return result;
    }
}