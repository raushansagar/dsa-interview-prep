
/*
    Implementation DFS 
*/


// Time Complexity O (V + E)
// Space Complexity O (Recursion Stack)

class Solution {
    public void DFS(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans){
        
        vis[u] = true;
        ans.add(u);
        
        for(int v : adj.get(u)){
            
            if(!vis[v]){
                DFS(v, adj, vis, ans);
            }
        }
        
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int V = adj.size();
        boolean[] vis = new boolean[V];
        
        for(int u = 0; u < V; u++){
            if(!vis[u]){
                DFS(u, adj, vis, ans);
            }
        }
        
        
        return ans;
    }
}