/*
    Directed Graph Cycle
    GFG Link :- https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*/



// DFS 

class Solution {
    public boolean DFS(int u, Map<Integer, List<Integer>> adj, boolean[] vis, boolean[] inRecursion){
        
        vis[u] = true;
        inRecursion[u] = true;
        
        for(int v : adj.getOrDefault(u, new ArrayList<>())){
            if(inRecursion[v]) return true;
            
            if(!vis[v] && DFS(v, adj, vis, inRecursion)){
                return true;
            }
        }
        
        inRecursion[u] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] d : edges){
            int u = d[0];
            int v = d[1];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);
        }
        
        boolean[] vis = new boolean[V];
        
        for(int u = 0; u < V; u++){
            boolean[] inRecursion = new boolean[V];
            
            if(!vis[u] && DFS(u, adj, vis, inRecursion)){
                return true;
            }
        }
        
        return false;
    }
}