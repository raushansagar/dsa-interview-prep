/*
    1020. Number of Enclaves
    Leetcode Link :- https://leetcode.com/problems/number-of-enclaves/description/
*/




// DFS

class Solution {
    public void DFS(int i, int j, int[][] board, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] == 0) return;

        board[i][j] = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int[] d : dir){
            int i_ = i + d[0];
            int j_ = j + d[1];

            DFS(i_, j_, board, n, m);
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            // left
            if(grid[i][0] == 1){
                DFS(i, 0, grid, n, m);
            }

            // right
            if(grid[i][m-1] == 1){
                DFS(i, m-1, grid, n, m);
            }
        }

        for(int j = 0; j < m; j++){
            // top
            if(grid[0][j] == 1){
                DFS(0, j, grid, n, m);
            }

            // buttom
            if(grid[n-1][j] == 1){
                DFS(n-1, j, grid, n, m);
            }
        }

        int land = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) land++;
            }
        }

        return land;
    }
}