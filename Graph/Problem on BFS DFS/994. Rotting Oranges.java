/*
    994. Rotting Oranges
    Leetcode Link :- https://leetcode.com/problems/rotting-oranges/description/
*/




class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == 2){

                    for(int[] d : dir){
                        int i_ = d[0] + i;
                        int j_ = d[1] + j;

                        if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && grid[i_][j_] == 1){
                            grid[i_][j_] = 0;
                            q.add(new int[]{i_, j_});
                        }
                    }

                }
            }
        }

        
        int minute = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size--> 0){
                int[] temp = q.remove();
                int i = temp[0];
                int j = temp[1];    

                for(int[] d : dir){
                    int i_ = d[0] + i;
                    int j_ = d[1] + j;

                    if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && grid[i_][j_] == 1){
                        grid[i_][j_] = 0;
                        q.add(new int[]{i_, j_});
                    }
                }
            }

            minute++;
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        

        return minute;
    }
}