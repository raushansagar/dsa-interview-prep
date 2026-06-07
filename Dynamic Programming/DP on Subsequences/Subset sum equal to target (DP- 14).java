/*
    Subset sum equal to target (DP- 14)
    Subset Sum Problem
 */



// Top Down
class Solution {
    public static boolean solve(int n, int[] arr, int target, int[][] dp){
        
        if(target == 0) return true;
        if(n == 0) return arr[n] == target;
        
        
        if(dp[n][target] != -1) return dp[n][target] == 1;
        
        boolean not_take = solve(n-1, arr, target, dp);
        boolean take = target >= arr[n] ? solve(n-1, arr, target-arr[n], dp) : false;
        
        dp[n][target] = (take || not_take) ? 1 : 0;
        
        return dp[n][target] == 1;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        
        return solve(n-1, arr, sum, dp);
    }
}