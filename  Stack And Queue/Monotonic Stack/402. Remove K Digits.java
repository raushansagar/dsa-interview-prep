/*  
    402. Remove K Digits
    Leetcode Link :- https://leetcode.com/problems/remove-k-digits/description/
 */



// Approch 1

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(char ch : num.toCharArray()){
            while(!st.isEmpty() && st.peek() > ch && k > 0){
                st.pop();
                k--;
            }

            st.push(ch);
        }


        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }

        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }

        while(ans.length() > 0 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}