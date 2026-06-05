



// Top down approch 

class Solution {
    public int solve(int n, int prev, int[][] mat, int m, int[][] memo){
        
        if(n < 0) return 0;
        int idx = prev == -1 ? m : prev;
        
        if(memo[n][idx] != -1) return memo[n][idx];
        int take = 0;
        
        // take activities 
        for(int act = 0; act < m; act++){
            if(act == prev) continue;
            
            int curr = mat[n][act] + solve(n-1, act, mat, m, memo);
            take = Math.max(curr, take);
        }
        
        return memo[n][idx] = take;
    }
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] memo = new int[n+1][m+1];
        for(int[] d : memo) Arrays.fill(d, -1);
        
        return solve(n-1, -1, mat, m, memo);
    }
}



// Buttom up approch 
class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] memo = new int[n+1][m+1];
        memo[0][0] = Math.max(mat[0][1], mat[0][2]);
        memo[0][1] = Math.max(mat[0][2], mat[0][0]);
        memo[0][2] = Math.max(mat[0][1], mat[0][0]);
        memo[0][3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));
        
        
        for(int day = 1; day < n; day++){
            for(int last = 0; last < 4; last++){
                int max = 0;
                
                for(int activities = 0; activities < m; activities++){
                    if(last == activities) continue;
                    
                    int curr = mat[day][activities] + memo[day-1][activities];
                    max = Math.max(curr, max);
                }
                
                memo[day][last] = max;
            }
        }
        
        
        return memo[n-1][3];
    }
}