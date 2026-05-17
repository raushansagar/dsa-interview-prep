/*
    Connected Components in an Undirected Graph
    GFG Link :- https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
 */




class Solution {
    public void DFS(int u, Map<Integer, List<Integer>> adj, boolean[] vis, ArrayList<Integer> list){
        vis[u] = true;
        list.add(u);
        
        for(int v : adj.getOrDefault(u, new ArrayList<>())){
            if(u == v) continue;
            
            if(!vis[v]){
                DFS(v, adj, vis, list);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] d : edges){
            int u = d[0];
            int v = d[1];
            
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int u = 0; u < V; u++){
            ArrayList<Integer> list = new ArrayList<>();
            
            if(!vis[u]){
                DFS(u, adj, vis, list);
                ans.add(list);
            }
        }
        
        return ans;
    }
}