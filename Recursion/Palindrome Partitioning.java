/*
    131 Palindrome Partitioning
    Leetcode Link :-  https://leetcode.com/problems/palindrome-partitioning/description/
*/



class Solution {
     List<List<String>> result = new ArrayList<>();
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;

        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
    public void solve(int idx, String s, List<String> curr){
        if(idx >= s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        

        for(int i = idx; i < s.length(); i++){
            String str = s.substring(idx, i+1);

            if(isPalindrome(str)){

                // take 
                curr.add(str);

                solve(i+1, s, curr);

                // backtrack
                curr.remove(curr.size()-1);
            }         
        }
    }
    public List<List<String>> partition(String s){
        solve(0, s, new ArrayList<>());
        return result;
    }
}