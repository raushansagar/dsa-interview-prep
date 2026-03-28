/*
    Letter Combinations of a Phone Number
    Leetcode Link :- https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */



class Solution {
    public void solve(int idx, String curr, String digits, String[] map, List<String> result){
        if(idx >= digits.length()){
            result.add(curr);
            return;
        }

        int digit = digits.charAt(idx)-'0';
        for(char ch : map[digit].toCharArray()){
            
            // take 
            curr = curr + ch;
            solve(idx+1, curr, digits, map, result);

            // backtrack
            curr = curr.substring(0, curr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] map = {".", "-", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        solve(0, "", digits, map, result);
        return result;
    }
}