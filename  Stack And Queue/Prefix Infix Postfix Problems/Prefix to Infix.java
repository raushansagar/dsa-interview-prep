/*
    Prefix to Infix Conversion
    GFG Link :- https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1
*/



// Approch 1
// T.C = O(n)

class Solution {
    static String preToInfix(String pre_exp) {
        Stack<String> st = new Stack<>();
        
        for(int i = pre_exp.length()-1; i >= 0; i--){
            char ch = pre_exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else{
                String op1 = st.pop();
                String op2 = st.pop();
                
                String temp = "(" + op1 + ch + op2 + ')';
                st.push(temp);
            }
        }
        
        
        return st.pop();
    }
}
