/*
    Prim's Algorithm 
    GFG Link :- https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_medium=article&utm_campaign=bottom_sticky_on_article&utm_source=gfg
 */




class Solution {
    public int spanningTree(int V, int[][] edges) {

        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] d : edges){
            int u = d[0];
            int v = d[1];
            int w = d[2];
            
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            
            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }
        
        int[] parent = new int[V];
        boolean[] vis = new boolean[V];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, -1, 0});
        
        parent[0] = -1;
        int sum = 0;
        
        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();
            int u = curr[0];
            int p = curr[1];
            int w = curr[2];
            
            if(vis[u]) continue;
            
            vis[u] = true;
            sum += w;

            for(int[] e : adj.get(u)){
                int v = e[0];
                int newWeg = e[1];
                
                if(!vis[v]){
                    parent[v] = u;
                    pq.offer(new int[]{v, u, newWeg});
                }
            }
        }
        
        
        
        return sum;
    }
}
