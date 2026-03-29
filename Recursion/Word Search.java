/*      

    79. Word Search
    Leetcode Link :- https://leetcode.com/problems/word-search/description/

 */



// Time complexity is O(n * m * 3^L)
// Space complexity O(L)

class Solution {
    public boolean solve(int idx, int i, int j, char[][] board, String word, int n, int m){
        if(idx >= word.length()-1){
            return true;
        }

        // visted
        char temp = board[i][j];
        board[i][j] = '#';

        int[][] dir = {{1,0},{0,1},{-1, 0}, {0,-1}};
        for(int[] d : dir){
            int i_ = d[0] + i;
            int j_ = d[1] + j;

            if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && board[i_][j_] != '#' && 
            board[i_][j_] == word.charAt(idx+1) && solve(idx+1, i_, j_, board, word, n, m)){
                return true;
            }
        }


        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0) && solve(0, i, j, board, word, n, m)){
                    return true;
                }
            }
        }

        return false;
    }
}