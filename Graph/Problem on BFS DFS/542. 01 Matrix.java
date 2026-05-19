/*
    542. 01 Matrix
    Leetcode Link :- https://leetcode.com/problems/01-matrix/description/
 */



class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, -1});
                    vis[i][j] = true;
                }
            } 
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!q.isEmpty()){
            int[] temp = q.remove();
            int i = temp[0];
            int j = temp[1];
            int weg = temp[2] + 1;

            mat[i][j] = weg;
            
            for(int[] d : dir){
                int i_ = d[0] + i;
                int j_ = d[1] + j;
                
                if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && !vis[i_][j_]){
                    vis[i_][j_] = true;
                    q.add(new int[]{i_, j_, weg});
                }
            }
        }


        return mat;
    }
}