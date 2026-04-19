/*
    3904. Smallest Stable Index II
    Leetcode Link :- https://leetcode.com/problems/smallest-stable-index-ii/
*/



// Approch 1
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        int[] max = new int[n];
        max[0] = nums[0];
        
        int[] min = new int[n];
        min[n-1] = nums[n-1];

        for(int i = n-2, j = 1; i >= 0; i--, j++){
            min[i] = Math.min(nums[i], min[i+1]);
            max[j] = Math.max(nums[j], max[j-1]);
        }

        for(int i = 0; i < n; i++){
            if((max[i] - min[i]) <= k) return i;
        }
        return -1;
    }
}