
/*  
    N-Queen Problem
    GFG Link :- https://www.geeksforgeeks.org/problems/n-queen-problem0315/1
*/


// Approch 1

import java.util.*;
class Solution1 {
    public boolean isSafe(int row, int col, char[][] board){
        int n = board.length;
        
        int[][] dir = {{1,1}, {-1,-1}, {1,-1}, {-1,1}, {0, 1}, {1, 0}, {-1,0}, {0, -1}};
        
        for(int[] d : dir){
            int dr = row+d[0];
            int dc = col+d[1];
            
            while(dr >= 0 && dr < n && dc >= 0 && dc < n){
                if(board[dr][dc] == 'Q'){
                    return false;
                }
                
                dr = dr + d[0];
                dc = dc + d[1];
            }
        }
        
        return true;
    }
    public void solve(int row, char[][] board, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
        if(row == board.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < board[0].length; i++){
            if(isSafe(row, i, board)){
                board[row][i] = 'Q';
                curr.add(i+1);
                solve(row+1, board, curr, result);
                
                board[row][i] = '.';
                curr.remove(curr.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        char[][] board = new char[n][n];
        for(char[] c : board){
            Arrays.fill(c, '.');
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solve(0, board, new ArrayList<>(), result);
        return result;
    }
}



// Approch 2
class Solution {
    public void solve(int row, int n, ArrayList<Integer> curr, HashSet<Integer> col, HashSet<Integer> dig, HashSet<Integer> antiDig, ArrayList<ArrayList<Integer>> result){
        if(row >= n){
            result.add(new ArrayList<>(curr));
            return;
        }
        

        for(int i = 0; i < n; i++){
            if(!col.contains(i) && !dig.contains(row+i) && !antiDig.contains(row-i)){
                col.add(i);
                dig.add(row+i);
                antiDig.add(row-i);
                curr.add(i+1);
                
                solve(row+1, n, curr, col, dig, antiDig, result);
                col.remove(i);
                dig.remove(row+i);
                antiDig.remove(row-i);
                curr.remove(curr.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> dig = new HashSet<>();
        HashSet<Integer> antiDig = new HashSet<>();
        
        solve(0, n, new ArrayList<>(), col, dig, antiDig, result);
        
        return result;
    }
}