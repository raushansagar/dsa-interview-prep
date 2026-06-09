/*
    Perfect Sum Problem
    GFG Link :- https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
*/







class Solution {
    public int solve(int n, int target, int[] nums, int[][] dp){
        if(n == 0){
            if(target == 0 && nums[n] == 0) return 2;
            if(target == 0 || nums[n] == target) return 1;
            return 0;
        }
        
        if(dp[n][target] != -1) return dp[n][target];
        
        // not take
        int not_take = solve(n-1, target, nums, dp);
        
        // take
        int take = 0;
        if(nums[n] <= target) take = solve(n-1, target-nums[n], nums, dp);
        
        return dp[n][target] = take + not_take;
    }
    public int perfectSum(int[] nums, int target) {
        
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        
        for(int[] d : dp) Arrays.fill(d, -1);
        
        return solve(n-1, target, nums, dp);
        
    }
}





// Tabulation 

class Solution {
    public int perfectSum(int[] nums, int target) {
        
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        
        
        if(nums[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
            if(nums[0] <= target) dp[0][nums[0]] = 1;
        }
        
        
        for(int i = 1; i < n; i++){
            for(int t = 0; t <= target; t++){
                
                int not_take = dp[i-1][t];
                
                int take = 0;
                if(nums[i] <= t) take = dp[i-1][t-nums[i]];
                
                
                dp[i][t] = take + not_take;
            }
        }
        

        return dp[n-1][target];
    }
}