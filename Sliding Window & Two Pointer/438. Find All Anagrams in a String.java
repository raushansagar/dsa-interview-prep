package Sliding Window & Two Pointer;

/*
    438. Find All Anagrams in a String
    Leetcode Link :- https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */



// Approch 

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for(char ch : p.toCharArray()){
            if(!map.containsKey(ch)) count++;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        
        while(j < n){
            char ch1 = s.charAt(j);

            map.put(ch1, map.getOrDefault(ch1, 0) - 1);
            if(map.get(ch1) == 0) count--;

            while(!map.isEmpty() && map.get(ch1) < 0){
                char ch2 = s.charAt(i);
                map.put(ch2, map.get(ch2) + 1);

                if(map.get(ch2) == 1) count++;
                i++;
            }
            

            if(count == 0){
                ans.add(i);
            }

            j++;
        }


        return ans;
    }
}