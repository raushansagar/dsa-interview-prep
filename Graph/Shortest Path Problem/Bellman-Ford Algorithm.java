/*
    Bellman-Ford
    GFG Link :- https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
*/



// Time compelixiy O(E * V)

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        
        int[] ans = new int[V];
        
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        
        // if graph is not negative cyle then its always find shortest weg in V-1 times
        for(int i = 0; i <= V-1; i++){
            
            boolean updated = false;
            
            for(int[] e : edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                
                if(ans[u] != Integer.MAX_VALUE && (ans[u] + w) < ans[v]){
                    ans[v] = ans[u] + w;
                    updated = true;
                }
            }
            
            if(!updated) break;
        }
        
        
        // negative cycle in graph 
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
                
            if(ans[u] != Integer.MAX_VALUE && (ans[u] + w) < ans[v]){
                return new int[] {-1};
            }
        }
        
        
        for(int i = 0; i < ans.length; i++){
            if(ans[i] == Integer.MAX_VALUE) ans[i] = (int)1e8;
        }
        
        return ans;
    }
}

