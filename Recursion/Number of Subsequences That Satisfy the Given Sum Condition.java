/*
    1498 Number of Subsequences That Satisfy the Given Sum Condition
    Leetcode :- https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
 */


// Approch 1
// Time complexity is O(2^n)

class Solution {
    public void solve(int idx, int[] nums, List<Integer> curr, int target, int[] count){
        if(idx >= nums.length){
            if(!curr.isEmpty() && curr.get(0) + curr.get(curr.size()-1) <= target){
                count[0] += 1;
            }
            return;
        }
        if(!curr.isEmpty() && curr.get(0) + curr.get(curr.size()-1) > target){
            return;
        }

        // take 
        curr.add(nums[idx]);
        solve(idx+1, nums, curr, target, count);

        // backtrack
        curr.remove(curr.size()-1);

        // not take
        solve(idx+1, nums, curr, target, count);
        
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[1];

        solve(0, nums, new ArrayList<>(), target, count);
        return count[0];
    }
}



// Approch 2
// Time complexity is O(n * log n)

class Solution2 {
    int mod = 1000000007;
    public long pow(int x, int n){
        if(n <= 0){
            return 1;
        }

        long half = pow(x, n/2);
        long res = (half * half) % mod;

        if(n%2 == 1) res =  (x * res) % mod;
        return res;
    }
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);

        int i = 0;
        int j = n-1;

        while(i <= j){
            int sum = nums[i]+nums[j];

            if(sum <= target){
                count =  (count + (int)pow(2, (j-i))) % mod;
                i++;
            }
            else if(sum > target){
                j--;
            }
        }

        return count;
    }
}