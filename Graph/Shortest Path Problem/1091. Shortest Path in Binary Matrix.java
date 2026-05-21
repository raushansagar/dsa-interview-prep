/*
    1091. Shortest Path in Binary Matrix
    Leetcode Link :- https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
*/



class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        
        int[][] shortestDistance = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(shortestDistance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[]{0, 0, 1});

        shortestDistance[0][0] = 1;
        
        // direction 
        int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1},{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();

            int i = curr[0];
            int j = curr[1];
            int distance = curr[2];

            if(shortestDistance[i][j] < distance) continue;

            for(int[] d : dir){
                int i_ = d[0] + i;
                int j_ = d[1] + j;
                int newDistance = distance + 1;

                if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && grid[i_][j_] == 0 && newDistance < shortestDistance[i_][j_]){
                    shortestDistance[i_][j_] = newDistance;
                    minHeap.offer(new int[]{i_, j_, newDistance});
                }
            }
        }


        return shortestDistance[n-1][m-1] == Integer.MAX_VALUE ? -1 : shortestDistance[n-1][m-1];
    }
}