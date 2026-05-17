
/*
    547. Number of Provinces
    Leetcode Link :- https://leetcode.com/problems/number-of-provinces/description/
*/



class Solution {
    public void DFS(int u, int[][] isConnected, boolean[] vis){
        vis[u] = true;

        for(int v = 0; v < isConnected.length; v++){
            if(u == v) continue;

            if(!vis[v] && isConnected[u][v] == 1){
                DFS(v, isConnected, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
    
        boolean[] vis = new boolean[V];
        int ans = 0;

        for(int u = 0; u < V; u++){
            if(!vis[u]){
                DFS(u, isConnected, vis);
                ans++;
            }
        }

        return ans;
    }
}