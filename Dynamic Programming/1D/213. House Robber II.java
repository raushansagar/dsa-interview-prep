/*
    213. House Robber II
    Leetcode Link :- 
 */


// Top down approch + memo

 class Solution {
    public int solve(int n, int[] nums, int[] memo, int i){
        if(n < i) return 0;
    
        if(memo[n] != -1) return memo[n];

        int take = nums[n] + solve(n-2, nums, memo, i);
        int not_take = 0 + solve(n-1, nums, memo, i);

        return memo[n] = Math.max(take, not_take);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];

        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        return Math.max(solve(n-2, nums, memo1, 0), solve(n-1, nums, memo2, 1));
    }
}




// Button up approch

class Solution2{
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int ans = Integer.MIN_VALUE;

        // 0 to n-2
        int[] dp = new int[n];
        dp[0] = nums[0];

        for(int i = 1; i <= n-2; i++){
            
            // take
            int take = nums[i];
            take += (i-2) >= 0 ? dp[i-2] : 0;
            
            // not take
            int notTake = dp[i-1];

            dp[i] = Math.max(take, notTake);
        }

        ans = Math.max(ans, dp[n-2]);
        Arrays.fill(dp, 0);

        // 1 to n-1
        dp[1] = nums[1];
        for(int i = 2; i < n; i++){
            
            // take
            int take = nums[i];
            take += (i-2) >= 0 ? dp[i-2] : 0;
            
            // not take
            int notTake = dp[i-1];

            dp[i] = Math.max(take, notTake);
        }

        ans = Math.max(ans, dp[n-1]);

        return ans;
    }
}
