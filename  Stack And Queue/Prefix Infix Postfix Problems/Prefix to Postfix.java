/*
    Prefix to Postfix Conversion
    GFG Link :- https://www.geeksforgeeks.org/problems/prefix-to-postfix-conversion/1
 */



// Approch 1
// T.C = O(n)


class Solution {
    static String preToPost(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i = s.length()-1; i >= 0; i--){
            char ch = s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else{
                String op1 = st.pop();
                String op2 = st.pop();
                
                String temp = ch+op2+op1;
                st.push(temp);
            }
        }
        
        StringBuilder str = new StringBuilder(st.pop());
        int si = 0, ei = str.length()-1;
        
        while(si < ei){
            char left = str.charAt(si);
            char right = str.charAt(ei);
            
            str.setCharAt(si, right);
            str.setCharAt(ei, left);
            
            si++;
            ei--;
        }
        
        return str.toString();
    }
}
