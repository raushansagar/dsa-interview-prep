/*
    Smallest subarray with sum greater than x
    GFG Link :- https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
 */





// Approch  1

class Solution {
    public static int smallestSubWithSum(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int i = 0, j = 0;
        int sum = 0;
        int idx = Integer.MAX_VALUE;

        while(j < n){
            sum += nums[j];

            while(sum > target && i <= j){
                
                if((j-i+1) <= idx){
                    ans = Math.min(ans, sum);
                    idx = j-i+1;
                }
                
                sum -= nums[i];
                i++;
            }


            j++;
        }

        return idx == Integer.MAX_VALUE ? 0 : idx;
    }
}
