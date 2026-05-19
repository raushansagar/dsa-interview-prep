
/*
    Undirected Graph Cycle
    Leetcode Link :- https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
*/



// Approch 1 DFS

class Solution {
    public boolean DFS(int u, int parent, HashMap<Integer, List<Integer>> adj, boolean[] vis){
        vis[u] = true;

        
        for(int v : adj.getOrDefault(u, new ArrayList<>())){
            
            if(v == parent) continue; 
            if(vis[v]) return true;
            
            if(!vis[v] && DFS(v, u, adj, vis)){
                return true;
            }
        }
        
        
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] d : edges){
            int u = d[0];
            int v = d[1];
            
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        

        
        boolean[] vis = new boolean[V];
        
        for(int u = 0; u < V; u++){
            if(!vis[u] && DFS(u, -1, adj, vis)){
                return true;
            }
        }
        
        return false;
    }
}
