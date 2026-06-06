/*
    64. Minimum Path Sum
    Leetcode Link :- https://leetcode.com/problems/minimum-path-sum/description/
 */



// Top down approch + memoizaions

class Solution {
    public int solve(int i, int j, int[][] grid, int n, int m, int[][] dp){
        if(i < 0 || i >= n || j < 0 || j >= m) return Integer.MAX_VALUE;
        if(i == n-1 && j == m-1) return grid[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int down = solve(i+1, j, grid, n, m, dp);
        int right = solve(i, j+1, grid, n, m, dp);

        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d, -1);

        return solve(0, 0, grid, n, m, dp);
    }
}




// Buttom up approch 
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    dp[0][0] = grid[0][0];
                }
                else{
                    int down = i > 0 ? dp[i-1][j] : Integer.MAX_VALUE;
                    int right = j > 0 ? dp[i][j-1] : Integer.MAX_VALUE;

                    dp[i][j] = grid[i][j] + Math.min(down, right);
                }
            }
        }

        return dp[n-1][m-1];
    }
}