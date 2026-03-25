/*
    String to Integer (atoi)
    Leetcode :- https://leetcode.com/problems/string-to-integer-atoi/
*/


class Solution {
    boolean sign = true;
    private boolean isDigit(char ch){
        return ch-'0' >= 0 && ch-'0' <= 9;
    }
    public void solve(int idx, String s, int n, long[] result){
        if(idx >= n || !isDigit(s.charAt(idx))){
            return;
        }

        // Handle MAX_VALUE || MIN_VALUE;
        if((result[0] > Integer.MAX_VALUE/10) || (result[0] == Integer.MAX_VALUE/10 && (s.charAt(idx)-'0') > 7)){
            result[0] = sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            return;
        }
        
        result[0] = result[0] * 10 + (s.charAt(idx)-'0');
        solve(idx+1, s, n, result);
    }
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            sign = s.charAt(0) == '-' ? false : true; 
            s = s.charAt(0) == '-' || s.charAt(0) == '+' ? s.substring(1, s.length()) : s;
        }

      
        long[] result = new long[1];
        solve(0, s, s.length(), result);

        return sign ? (int)result[0] : -1 * (int)result[0];
    }
}