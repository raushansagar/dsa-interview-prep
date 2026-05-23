/*
    1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
    Leetcode Link :- https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
*/




class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int[] d : edges){
            int u = d[0];
            int v = d[1];
            int w = d[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int via = 0; via < n; via++){
            for(int u = 0; u < n; u++){
                for(int v = 0; v < n; v++){
                    if(dist[u][via] == Integer.MAX_VALUE 
                    || dist[via][v] == Integer.MAX_VALUE) continue;
                    dist[u][v] = Math.min(dist[u][v], (dist[u][via] + dist[via][v]));
                }
            }
        }


        int count = n;
        int city =  0;

        for(int u = 0; u < n; u++){
            int curr = 0;

            for(int v = 0; v < n; v++){
                if(dist[u][v] <= distanceThreshold) curr++;
            }

            if(curr < count){
                count = curr;
                city = u;
            }
            else if(curr == count){
                city = u;
            }
        }

        return city;
    }
}