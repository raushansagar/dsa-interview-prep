/*
    1463. Cherry Pickup II
    Leetcode Link :- https://leetcode.com/problems/cherry-pickup-ii/description/
*/



// Top down + mamoization
class Solution {
    public int solve(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp){
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return (int) 1e8 * -1;
        }
        if(i == n-1){
            return j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int[] dir = {0, -1, 1};
        int maxPath = Integer.MIN_VALUE;

        for(int dir1 : dir){
            for(int dir2 : dir){

                int currPath = 0;
                if(j1 == j2){
                    currPath = grid[i][j1] + solve(i+1, j1+dir1, j2+dir2, grid, n, m, dp);
                }
                else{
                    currPath = (grid[i][j1] + grid[i][j2]) + solve(i+1, j1+dir1, j2+dir2, grid, n, m, dp);
                }

                maxPath = Math.max(maxPath, currPath);
            }
        }


        return dp[i][j1][j2] = maxPath;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for(int[][] d : dp){
            for(int[] t : d){
                Arrays.fill(t, -1);
            }
        }

        return solve(0, 0, m-1, grid, n, m, dp);
    }
}




// Buttom up 

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        int[] dir = {0, -1, 1};

        // base case
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(i == j){
                    dp[n-1][i][j] = grid[n-1][i];
                }
                else{
                    dp[n-1][i][j] = (grid[n-1][i] + grid[n-1][j]);
                }
            }
        }


        for(int i = n-2; i >= 0; i--){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){

                    int max = 0;

                    for(int dir1 : dir){
                        for(int dir2 : dir){

                            int curr = (int) 1e8*-1;

                            if(j1 == j2){
                                curr = grid[i][j1];
                            }
                            else{
                                curr = grid[i][j1] + grid[i][j2];
                            }

                            if(j1+dir1 >= 0 && j1+dir1 < m && j2+dir2 >= 0 && j2+dir2 < m){
                                curr += dp[i+1][j1+dir1][j2+dir2];
                            }
                            else{
                                curr += (int) 1e8*-1;
                            }

                            max = Math.max(max, curr);
                        }
                    }


                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][m-1];
    }
}