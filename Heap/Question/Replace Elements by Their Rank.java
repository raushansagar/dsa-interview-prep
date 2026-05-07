

/*
    Replace Elements by Their Rank
    GFG Link :- https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1
 */



// Approch 1

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for(int val : arr){
            pq.add(val);
        }
        
        int p = 1;
        while(!pq.isEmpty()){
            int key = pq.remove();
            
            if(!map.containsKey(key)){
                map.put(key, p);
                p++;
            }
        }
        
        int[] ans = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            ans[i] = map.get(arr[i]);
        }
        
        return ans;
    }
}
