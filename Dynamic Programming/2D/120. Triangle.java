/*
    120. Triangle
    Leetcode Link :- https://leetcode.com/problems/triangle/description/
 */



// Top down approch  + memoization

class Solution {
    public int solve(int i, int j, List<List<Integer>> triangle, int n, int[][] dp){
        if(j > i) return Integer.MAX_VALUE;
        if(i == n-1) return triangle.get(i).get(j);

        if(dp[i][j] != -1) return dp[i][j];

        int down =  solve(i+1, j, triangle, n, dp);
        int right = solve(i+1, j+1, triangle, n, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d, -1);
    
        return solve(0, 0, triangle, n, dp);
    }
}





// Buttom up approch 

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down =  dp[i+1][j];
                int right = dp[i+1][j+1];

                dp[i][j] = triangle.get(i).get(j) + Math.min(down, right);
            }
        }

        return dp[0][0];
    }
}