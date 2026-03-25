/*
    Rat in a Maze
    GFG Link :- https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
*/




class Solution {
    public void findPath(int[][] maze, String curr, int i, int j, int n, int m, ArrayList<String> result){
        if(i < 0 || i>= n || j < 0 || j >= m || maze[i][j] == 0){
            return;
        }
        if(i == n-1 && j == m-1){
            result.add(curr);
            return;
        }
        
        maze[i][j] = 0;
        
        // down
        findPath(maze, curr+'D', i+1, j, n, m, result);
        // left
        findPath(maze, curr+'L', i, j-1, n, m, result);
        // right
        findPath(maze, curr+'R', i, j+1, n, m, result);
        // up
        findPath(maze, curr+'U', i-1, j, n, m, result);
        
        maze[i][j] = 1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        
        ArrayList<String> result = new ArrayList<>();
        if(maze[0][0] == 0 || maze[n-1][m-1] == 0) return result;
        
        findPath(maze, "", 0, 0, n, m, result);
        
        return result;
    }
}