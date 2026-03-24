/*
    Power Set
    Leetcode : https://www.geeksforgeeks.org/problems/power-set4302/1
 */



import  java.util.*;
class solution {
    public void solve(int idx, String s, int n, String curr, List<String> result){
        if(idx >= n){
           if(curr.length() > 0) result.add(curr);
            return;
        }
        
        
        // take 
        curr = curr + s.charAt(idx);
        solve(idx+1, s, n, curr, result);
        
        // backtrack
        curr = curr.substring(0, curr.length()-1);
        
        // not take
        solve(idx+1, s, n, curr, result);
    }
    public List<String> AllPossibleStrings(String s) {
        int n = s.length();
        List<String> result = new ArrayList<>();
        
        solve(0, s, n, "", result);
        Collections.sort(result);
        
        return result;
    }
}