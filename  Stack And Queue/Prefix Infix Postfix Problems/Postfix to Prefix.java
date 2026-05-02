
/*
    Postfix to Prefix Conversion
    GFG Link :- 
 */


// Approch 1
// T.C = O(n)

class Solution {
    static String postToPre(String post_exp) {
        Stack<String> st = new Stack<>();
        
        for(int i = 0; i < post_exp.length(); i++){
            char ch = post_exp.charAt(i);
            
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
        
        
        return st.pop();
    }
}
