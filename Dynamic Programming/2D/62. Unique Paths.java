/*
    62. Unique Paths
    Leetcode Link :- https://leetcode.com/problems/unique-paths/description/
*/




// Top to down + memoization
class Solution {
    public int solve(int i, int j, int m, int n, int[][] memo){
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;

        if(memo[i][j] != -1) return memo[i][j];

        int left = solve(i+1, j, m, n, memo);
        int right = solve(i, j+1, m, n, memo);

        return memo[i][j] = left + right;
    }
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for(int[] dp : memo) Arrays.fill(dp, -1);

        return solve(0, 0, m, n, memo);
    }
}



// Buttom to up
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int top = 0, left = 0;

                if(i == 0 && j == 0){
                    memo[i][j] = 1;
                }
                else{
                    top = i > 0 ? memo[i-1][j] : 0;
                    left = j > 0 ? memo[i][j-1] : 0;
                    memo[i][j] = top + left;
                }
            }
        }

        return memo[m-1][n-1];
    }
}