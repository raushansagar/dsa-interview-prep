/*  
    785. Is Graph Bipartite?
    Leetcode Link :- https://leetcode.com/problems/is-graph-bipartite/description/
*/




// DFS
class Solution {
    public boolean DFS(int u, int parent, int currColor, int[][] graph, boolean[] vis, int[] color){

        vis[u] = true;
        color[u] = currColor;

        for(int v : graph[u]){

            if(v == parent) continue;
            if(color[v] == currColor) return true;

            if(!vis[v] && DFS(v, u, 1-currColor, graph, vis, color)){
                return true;
            }
        }

        return false;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        
        int[] color = new int[V];
        Arrays.fill(color, -1);

        boolean[] vis = new boolean[V];

        for(int u = 0; u < V; u++){
            if(!vis[u] && DFS(u, -1, 0, graph, vis, color)){
                return false;
            }
        }


        return true;
    }
}




