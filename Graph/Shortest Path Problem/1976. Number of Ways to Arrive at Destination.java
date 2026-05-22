/*
    1976. Number of Ways to Arrive at Destination
    Leetcode Link :- https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
*/




class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] e : roads){
            int u = e[0];
            int v = e[1];
            int time = e[2];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        int[] ways = new int[n];
        long[] ans = new long[n];
        Arrays.fill(ans, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        ans[0] = 0;
        ways[0] = 1;
        
        int mod = (int)1e9+7;

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int u = (int)curr[0];
            long time = curr[1];
            int currWay = ways[u];
                
            if(ans[u] < time) continue;

            for(int[] e : adj.getOrDefault(u, new ArrayList<>())){
                int v = e[0];
                long newTime = e[1] + time;

                if(ans[v] == newTime){
                        ways[v] = (int)((1L * ways[v] + currWay) % mod);
                }
                else if(newTime < ans[v]){
                    ways[v] = currWay;
                    ans[v] = newTime;
                    pq.offer(new long[]{v, newTime});
                }
            }
        }

         
        return ways[n-1];
    }
}