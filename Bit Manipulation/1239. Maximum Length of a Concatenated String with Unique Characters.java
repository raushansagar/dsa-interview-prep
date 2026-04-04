/*  
    1239. Maximum Length of a Concatenated String with Unique Characters
    Leetcode Link :- https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
*/




// Approch 1
// Time compelxity O(2^n * k)  n = size of arr and k = size of two concat string

class Solution {
    int[] maxLen = new int[1];
    public boolean isPossible(String s1, String s2){
        int[] freq = new int[26];

        for(char ch : s1.toCharArray()){
            int idx = ch-'a';
            if(freq[idx] > 0) return false;

            freq[idx]++;
        }

        for(char ch : s2.toCharArray()){
            int idx = ch-'a';
            if(freq[idx] > 0) return false;
            
            freq[idx]++;
        }

        return true;
    }
    public void solve(int idx, String curr, List<String> arr){
        maxLen[0] = Math.max(maxLen[0], curr.length());
        
        if(idx >= arr.size()){
            return;
        }

        if(isPossible(curr, arr.get(idx))){
            // take 
            solve(idx+1, curr+arr.get(idx), arr);
        }

        // not take 
        solve(idx+1, curr, arr);
    }
    public int maxLength(List<String> arr) {
        solve(0, "", arr);
        
        return maxLen[0];
    }
}


// Approch 2
// Total time complexity = O(2^n) + O(n * k) 
class Solution2{
    int[] maxLen = new int[1];
    public void solve(int idx, int curr, List<Integer> list){
        int len = Integer.bitCount(curr);
        maxLen[0] = Math.max(maxLen[0], len);

        if(idx >= list.size()){
            return;
        }

        if((curr & list.get(idx)) == 0){
            // take 
            solve(idx+1, (curr | list.get(idx)), list);
        }

        // not take 
        solve(idx+1, curr, list);
    }
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();

        // O(n * k) n = no of arr and k = 26 no of character
        for(String s : arr){
            int val = 0;

            for(char ch : s.toCharArray()){
                int idx = ch-'a';

                if((val & (1 << idx)) != 0){
                    val = -1;
                    break;
                }

                val = val | (1 << idx);
            }

            if(val >= 0) list.add(val);
        }

        // O(2^n) 

        // Total time complexity = O(2^n) + O(n * k) 
        solve(0, 0, list);
        return maxLen[0];
    }
}