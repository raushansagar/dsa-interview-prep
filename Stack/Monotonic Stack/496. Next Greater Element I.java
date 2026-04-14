/*
    496. Next Greater Element I
    Leetcode Link :- https://leetcode.com/problems/next-greater-element-i/description/
*/

// Approch  1
// Time Complexity O(n^2)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            int max = 0;

            for(int val : nums2){

                if(nums1[i] == val){
                    max = -1;
                }
                else if(max == -1 && nums1[i] < val){
                    max = Math.max(val, max);
                    break;
                }
            }

            result[i] = max;
        }

        return result;
    }
}


// Approch 2
// T.C = O(n * k)


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        

        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        
        for(int i = 0; i < n; i++){
            int max = -1;

            for(int j = map.get(nums1[i])+1; j < nums2.length; j++){
                if(nums1[i] < nums2[j]){
                    max = Math.max(max, nums2[j]);
                    break;
                }
            }

            result[i] = max;
        }

        return result;
    }
}
