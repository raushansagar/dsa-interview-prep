/*
    200. Number of Islands
    Leetcode Link :- https://leetcode.com/problems/number-of-islands/description/
*/




class Solution {
    public void DFS(int i, int j, char[][] grid, boolean[][] vis, int n, int m){

        vis[i][j] = true;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0} , {0, -1}};

        for(int[] d : dir){
            int i_ = d[0] + i;
            int j_ = d[1] + j;

            if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && !vis[i_][j_] && grid[i_][j_] == '1'){
                DFS(i_, j_, grid, vis, n, m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int islands = 0;
        boolean[][] vis = new boolean[n][m];
        

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    DFS(i, j, grid, vis, n, m);
                    islands++;
                }
            }
        }


        return islands;
    }
}