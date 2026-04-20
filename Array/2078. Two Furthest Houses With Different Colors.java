/*
    2078. Two Furthest Houses With Different Colors
    Leetcode :- https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/?envType=daily-question&envId=2026-04-20
*/


// Approch 1
// T.C = O(n^2)


class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(colors[i] != colors[j]){
                    max = Math.max(max, Math.abs(i-j));
                }
            }
        }

        return max;
    }
}