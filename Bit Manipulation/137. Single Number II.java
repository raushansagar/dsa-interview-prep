/*
    137. Single Number II
    Leetcode Link :- https://leetcode.com/problems/single-number-ii/description/
 */




// Approch 1
// Time complexity O(n)
// Space complexity O(n)

class Solution1{
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) +1);
        }

        for(int key : map.keySet()){
            if(map.get(key) == 1) return key;
        }

        return 0;
    }
}




// Approch 2
// Time complexity O(n logn)
// Space complexity O(1)

class Solution2{
    public int singleNumber(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        Arrays.sort(nums);
        
        for(int i = 1; i < n-1; i++){
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1]) return nums[i];
        }

        return nums[0] != nums[1] ? nums[0] : nums[n-1];
    }
}


// Approch 3
// Time complexity O(n)
// Space complexity O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int result = 0;

        // Time compexity O(32 * n)
        for(int bit = 0; bit <= 31; bit++){
            int one = 0;

            for(int val : nums){
                if((val & (1 << bit)) !=  0){
                    one += 1;
                }
            }

            if(one%3 == 1){
                result = (result | (1 << bit));
            }
        }

        return result;
    }
}
