
/*
    Maximum sum of non adjacent elements
 */


// Top down approch 

class Solution {
    public int solve(int idx, int[] nums, int n, int[] memo){
        if(idx >= n) return 0;
        if(memo[idx] != -1) return memo[idx];

        int take = nums[idx] + solve(idx+2, nums, n, memo);
        int not_take = solve(idx+1, nums, n, memo);

        return memo[idx] = Math.max(take, not_take);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return solve(0, nums, n, memo);
    }
}




// Button up approch 
class Solution {
    public int rob(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] memo = new int[n];
        memo[0] = nums[0];

        for(int i = 1; i < n; i++){

            int take = nums[i];
            take += (i > 1) ? memo[i-2] : 0;

            int not_take = memo[i-1];

            memo[i] = Math.max(take, not_take);
        }

        return memo[n-1];
    }
}   