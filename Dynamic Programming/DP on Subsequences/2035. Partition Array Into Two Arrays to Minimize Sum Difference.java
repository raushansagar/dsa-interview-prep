

/*
    2035. Partition Array Into Two Arrays to Minimize Sum Difference
 */








// Buttom to up
// for positive no 

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++) sum += nums[i];
        int k = sum/2;

        int[][] dp = new int[n][k+1];

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


        int min = (int) 1e8;
        for(int si = 0; si <= k; si++){
            if(dp[n-1][si] == 1){
                min = Math.min(min, Math.abs(sum - 2 * si));
            }
        }

        return min;
    }
}
