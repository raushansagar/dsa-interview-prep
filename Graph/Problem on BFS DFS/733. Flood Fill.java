
/*
    733. Flood Fill
    Leetcode Link :- https://leetcode.com/problems/flood-fill/description/
*/



// Apprich 1 DFS

class Solution {
    public void DFS(int i, int j, int[][] image, boolean[][] vis, int color){
        int n = image.length;
        int m = image[0].length;

        vis[i][j] = true;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int[] d : dir){
            int i_ = d[0] + i;
            int j_ = d[1] + j;

            if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && !vis[i_][j_] && image[i][j] == image[i_][j_]){
                DFS(i_, j_, image, vis, color);
            }
        }

        image[i][j] = color;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        boolean[][] vis = new boolean[n][m];
        DFS(sr, sc, image, vis, color);

        return image;
    }
}

// Approch 2 BFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;

        while(!q.isEmpty()){
            int size = q.size();

            while(size--> 0){
                int[] temp = q.remove();
                int i = temp[0], j = temp[1];

                for(int[] d : dir){
                    int i_ = d[0] + i;
                    int j_ = d[1] + j;

                    if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && image[i_][j_] == image[i][j] && !vis[i_][j_]){
                        vis[i_][j_] = true;
                        q.add(new int[]{i_, j_});
                    }
                }

                image[i][j] = color;
            }
        }


        return image;
    }
}