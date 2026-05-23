/*
    Floyd Warshall Algorithum
    GFG Link :- https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
*/





class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int infinity = (int)1e8;
        
        // find the min dis between the every pair of vertex
        for(int via = 0; via < n; via++){
            for(int u = 0; u < n; u++){
                for(int v = 0; v < n; v++){
                    if(dist[u][via] == infinity || dist[via][v] == infinity) continue;
                    
                    dist[u][v] = Math.min(dist[u][v], (dist[u][via] + dist[via][v]));
                }
            }
        }
        
        
        // check negative cycle 
        // for(int u = 0; u < n; u++){
        //     for(int v = 0; v < m; v++){
        //         if(dist[u][v] < 0) return true;
        //     }
        // }
    }
}