/*
    1004. Max Consecutive Ones III
    Leetcode Link :- 
 */



class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0, ans = 0;

        while(i < n){
            k += (nums[i] == 1 ? 0 : -1);

            while(k < 0 && j <= i){
                if(nums[j] == 0) k += 1;
                j++;
            }

            ans = Math.max(ans, (i-j+1));
            i++;
        }

        return ans;
    }
}