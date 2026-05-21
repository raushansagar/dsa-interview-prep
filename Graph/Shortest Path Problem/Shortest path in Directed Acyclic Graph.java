/*  
    Shortest path in Directed Acyclic Graph
    GFG Link :- https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
*/



class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, w});
        }
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE); 
        ans[0] = 0;
        
        while(!pq.isEmpty()){
            
            int[] temp = pq.poll();
            int u = temp[0];
            int w = temp[1];
            
            if(ans[u] < w) continue;
            
            for(int[] e : adj.getOrDefault(u, new ArrayList<>())){
                int v = e[0];
                int newWeg = w + e[1];
                
                if(newWeg < ans[v]){
                    ans[v] = newWeg;
                    pq.offer(new int[]{v, newWeg});
                }
            }
        }
        
        
        for(int i = 0; i < V; i++){
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        
        return ans;
    }
}
