/*
    Kruskal's Algorithm
    GFG Link :- https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_medium=article&utm_campaign=bottom_sticky_on_article&utm_source=gfg
*/



class Solution {
    
    // find and union by path compression
    public int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
    
    // union 
    public void union(int x, int y, int[] parent, int[] rank) {

        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if(x_parent == y_parent) return;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[y_parent] = x_parent;
            rank[x_parent] += 1;
        }
    }
    
    public int spanningTree(int V, int[][] edges) {
        
        List<int[]> list = new ArrayList<>();
        
        for(int[] d : edges){
            int u = d[0];
            int v = d[1];
            int w = d[2];
            
            list.add(new int[]{u, v, w});
        }
        
        int[] rank = new int[V];
        int[] parent = new int[V];
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        list.sort((a, b) -> a[2] - b[2]);
        int sum = 0;
        
        for(int i = 0; i < list.size(); i++){
            
            int[] curr = list.get(i);
    
            int u = curr[0];
            int v = curr[1];
            int w = curr[2];
            
            int x_parent = find(u, parent);
            int y_parent = find(v, parent);
            
            
            if(x_parent != y_parent){
                union(u, v, parent, rank);
                sum += w;
            }
        }
        
        
        return sum;
    }
}
