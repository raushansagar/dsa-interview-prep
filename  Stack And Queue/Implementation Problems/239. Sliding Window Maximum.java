

/*  
    239. Sliding Window Maximum
    Leetcode Link :- https://leetcode.com/problems/sliding-window-maximum/description/
*/



// Approch 1 
// Time complexity O(n log n)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> list = new LinkedList<>();

        int n = nums.length;
        int i = 0, j = 0;
        

        while(i < n){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while(!map.isEmpty() && (i-j+1) > k){
                map.put(nums[j], map.getOrDefault(nums[j], 0) - 1);
                if(map.get(nums[j]) <= 0) map.remove(nums[j]); 
                j++;
            }


            if((i-j+1) == k){
                list.add(map.lastKey());
            }

            i++;
        }

        int[] ans = new int[list.size()];
        for(int z = 0; z < ans.length; z++) ans[z] = list.get(z);

        return ans;
    }
}



// Approch 2
// Time complexity O(n)
// Space complexity O(n)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;

        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[n-k+1];

        while(i < n){
            
            // maintain size
            while(!dq.isEmpty() && dq.peekFirst() <= (i-k)){
                dq.pollFirst();
            }

            // remove min elements
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            
            dq.offerLast(i);

            if(i >= k-1){
                ans[i-k+1] = nums[dq.peekFirst()];
            }
            i++;
        }

        return ans;
    }
}