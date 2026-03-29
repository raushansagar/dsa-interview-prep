/*  
    139. Word Break
    Leetcode Link :- https://leetcode.com/problems/word-break/submissions/1963073963/
*/



// Approch 1
class Solution1 {
    public boolean solve(int idx, String target, Set<String> st){
        if(idx >= target.length()){
            return true;
        }

        for(int i = idx; i < target.length(); i++){
            String s = target.substring(idx, i+1);

            if(st.contains(s) && solve(i+1, target, st)){
                return true;
            }
        }

        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>();

        for(String str : wordDict){
            st.add(str);
        }

        return solve(0, s, st);
    }
}




// Approch 2

class Solution {
    Boolean[] memo;
    public boolean solve(int idx, String target, Set<String> st){
        if(idx >= target.length()){
            return true;
        }

        if(memo[idx] != null){
            return memo[idx];
        }

        for(int i = idx; i < target.length(); i++){
            String s = target.substring(idx, i+1);

            if(st.contains(s) && solve(i+1, target, st)){
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>();

        memo = new Boolean[s.length()];

        for(String str : wordDict){
            st.add(str);
        }

        return solve(0, s, st);
    }
}