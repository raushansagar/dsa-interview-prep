
/*
    Kth Smallest
    GFG Link :- https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
 */


// Approch 1

class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a-b);

        for(int val : arr){
            pq.add(val);
        }

        while(k--> 1){
            pq.remove();
        }

        return pq.peek();
    }
}
