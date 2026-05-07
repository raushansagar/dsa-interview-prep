/*
    209. Minimum Size Subarray Sum
    Leetcode Link :- https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */



// Approch 1

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int i = 0, j = 0;
        int sum = 0;

        while(j < n){
            sum += nums[j];

            while((sum-nums[i]) >= target && i <= j){
                sum -= nums[i];
                i++;
            }

            if(sum >= target){
                ans = Math.min(ans, (j-i+1));
            }

            j++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}