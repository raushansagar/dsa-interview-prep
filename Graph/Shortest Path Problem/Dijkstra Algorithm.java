/*
    Dijkstra Algorithm
    GFG Link :- https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 */



// Time compelixiy O(E * V)

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
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
        
        
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});
        ans[src] = 0;
        
        
        while(!pq.isEmpty()){
            
            int[] temp = pq.remove();
            int u = temp[0];
            int w = temp[1];

            if(ans[u] > w) continue;
            
            for(int[] d : adj.getOrDefault(u, new ArrayList<>())){
                int v = d[0];
                int newWeg = w + d[1];
                
                if(newWeg < ans[v]){
                    ans[v] = newWeg;
                    pq.add(new int[]{v, newWeg});
                }
            }
        }
        
        
        return ans;
    }
}

