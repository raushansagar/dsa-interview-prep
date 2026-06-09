
/*
    416. Partition Equal Subset Sum
    Leetcode Link :- https://leetcode.com/problems/partition-equal-subset-sum/description/
*/







// Top Down approch 
class Solution1 {
    public boolean solve(int idx, int curr, int target, int[] nums, int[][] dp){
        if(curr > target || idx < 0) return false;
        if(curr == target) return true;

        if(dp[idx][curr] != -1) return dp[idx][curr] == 1;

        boolean take = solve(idx-1, curr+nums[idx], target, nums, dp);
        boolean not_take = solve(idx-1, curr, target, nums, dp);

        dp[idx][curr] = (take || not_take) ? 1 : 0;

        return dp[idx][curr] == 1;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int val : nums) sum += val;

        if(sum%2 != 0) return false;

        int[][] dp = new int[n+1][sum+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return solve(n-1, 0, sum/2, nums, dp);
    }
}





// Buttom up approch 
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++) sum += nums[i];

        if(sum % 2 != 0) return false;
        int k = sum/2;

        int[][] dp = new int[n+1][k+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }

        if(nums[0] <= k){
            dp[0][nums[0]] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int target = 0; target <= k; target++){
                
                // not take
                boolean not_take = dp[i-1][target] == 1;

                // take 
                boolean take = false;   
                if(nums[i] <= target) take = dp[i-1][target-nums[i]] == 1;
                
                dp[i][target] = take || not_take ? 1 : 0;
            }
        }

        return dp[n-1][k] == 1;
    }
}