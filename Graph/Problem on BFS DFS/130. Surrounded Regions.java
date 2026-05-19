/*
    130. Surrounded Regions
    Leetcode Link :- https://leetcode.com/problems/surrounded-regions/description/
 */



// DFS

class Solution {
    public void DFS(int i, int j, char[][] board, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') return;

        board[i][j] = '#';
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int[] d : dir){
            int i_ = i + d[0];
            int j_ = j + d[1];

            DFS(i_, j_, board, n, m);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            // left
            if(board[i][0] == 'O'){
                DFS(i, 0, board, n, m);
            }

            // right
            if(board[i][m-1] == 'O'){
                DFS(i, m-1, board, n, m);
            }
        }

        for(int j = 0; j < m; j++){
            // top
            if(board[0][j] == 'O'){
                DFS(0, j, board, n, m);
            }

            // buttom
            if(board[n-1][j] == 'O'){
                DFS(n-1, j, board, n, m);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '#') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }
}