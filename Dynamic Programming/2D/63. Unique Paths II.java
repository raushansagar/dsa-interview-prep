

/*
    63. Unique Paths II
    Leetcode Link :- https://leetcode.com/problems/unique-paths-ii/description/
*/




// Top down approch 
class Solution {
    int mod = (int) 1e9 * 2;
    public int solve(int i, int j, int m, int n, int[][] mat, int[][] memo){
        if(i < 0 || i >= m || j < 0 || j >= n || mat[i][j] == 1) return 0;
        if(i == m-1 && j == n-1) return 1;

        if(memo[i][j] != -1) return memo[i][j];

        int left = solve(i+1, j, m, n, mat, memo);
        int right = solve(i, j+1, m, n, mat, memo);

        return memo[i][j] = (left + right) % mod;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m+1][n+1];
        for(int[] dp : memo) Arrays.fill(dp, -1);

        return solve(0, 0, m, n, obstacleGrid, memo);
    }
}




// Buttom up approch
class Solution {
    int mod = (int) 1e9 * 2;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int top = 0, left = 0;

                if(i == 0 && j == 0 && obstacleGrid[i][j] != 1){
                    memo[i][j] = 1;
                }
                else if(obstacleGrid[i][j] == 1){
                    memo[i][j] = 0;
                }
                else{
                    top = i > 0 ? memo[i-1][j] : 0;
                    left = j > 0 ? memo[i][j-1] : 0;
                    memo[i][j] = (top + left) % mod;
                }
            }
        }

        return memo[m-1][n-1];
    }
}