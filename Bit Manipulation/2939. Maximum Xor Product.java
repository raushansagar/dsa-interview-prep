/*
    2939. Maximum Xor Product
    Leetcode Link :- https://leetcode.com/problems/maximum-xor-product/description/
 */





// Approch 1
// Time compexity O(1)

class Solution {
    int mod = 1000000007;
    public int maximumXorProduct(long a, long b, int n) {
        long xorA = 0;
        long xorB = 0;

        for(int i = 49; i >= n; i--){
            boolean setA = ((a >> i) & 1) > 0;
            boolean setB = ((b >> i) & 1) > 0;

            if(setA) xorA ^= (1L << i);
            if(setB) xorB ^= (1L << i);
        }

        for(int i = n-1; i >= 0; i--){
            boolean setA = (a & (1L << i)) > 0;
            boolean setB = (b & (1L << i)) > 0;

            if(setA == setB){
                xorA ^= (1L << i);
                xorB ^= (1L << i);
            }
            else{
                if(xorA < xorB){
                    xorA ^= (1L << i);
                }
                else{
                    xorB ^= (1L << i);
                }
            }
        }

        xorA = xorA % mod;
        xorB = xorB % mod;

        return (int)((xorA*xorB) % mod);
    }
}