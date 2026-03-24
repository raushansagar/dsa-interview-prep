/*
    GFG Link : https://www.geeksforgeeks.org/problems/subsets-1613027340/1
 */

// Time Compexity :- O(2^n * n)

import  java.util.*;
class Solution {
    public void solve(int idx, int[] arr, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
        if(idx >= arr.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // take
        temp.add(arr[idx]);
        solve(idx+1, arr, temp, result);
        
        // backtrack
        temp.remove(temp.size()-1);
        
        // not take
        solve(idx+1, arr, temp, result);
    }
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        solve(0, arr, new ArrayList<>(), result);
        return result;
    }
}