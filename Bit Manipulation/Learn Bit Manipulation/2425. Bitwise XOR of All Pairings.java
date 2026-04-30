/*
    2425. Bitwise XOR of All Pairings
    Leetcode Link :- https://leetcode.com/problems/bitwise-xor-of-all-pairings/description/
 */


// Approch 1
// T.C = O(n * m)

class Solution1{
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int xor = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                xor ^= nums1[i] ^ nums2[j];
            }
        }
        
        return xor;
    }
}

// Approch 1
// T.C = O(k) (k = max of n, m)

class Solution2{
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int xor = 0;
        for(int i = 0; i < n && m%2 == 1; i++){
            xor ^= nums1[i];
        }

        for(int i = 0; i < m && n%2 == 1; i++){
            xor ^= nums2[i];
        }
        
        return xor;
    }
}