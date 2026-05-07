package Heap.Question;

/*
    k sorted array
    GFG Link :- https://www.geeksforgeeks.org/problems/k-sorted-array1610/1
 */



// Approch 

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(int i = 0; i < n; i++){
            pq.add(new int[]{arr[i], i});
        }
        
        int i = 0;
        while(!pq.isEmpty()){
            int val = Math.abs(i-pq.remove()[1]);
            if(val > k) return "No";
            i++;
        }
        
        
        return "Yes";
    }
}