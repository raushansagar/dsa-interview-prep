/*
    Minimum Multiplications to reach End
    GFG Link :- https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
*/


// Approch 

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        
        int mod = (int)1e3;
        if(end > mod) return -1;
        
        int[] ans = new int[mod];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        ans[start] = 0;
        
        
        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();
            int u = curr[0];
            int steps = curr[1];
            
            if(ans[u] < steps) continue;
            
            for(int i = 0; i < arr.length; i++){
                int v = (int)((1L * u * arr[i]) % mod);
                int newSteps = steps+1;
                
                if(newSteps < ans[v]){
                    ans[v] = newSteps;
                    pq.offer(new int[]{v, newSteps});
                }
            }
        }
        
        
        return ans[end] == Integer.MAX_VALUE ? -1 : ans[end];
    }
}