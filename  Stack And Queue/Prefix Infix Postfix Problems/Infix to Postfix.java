/*
    Infix to Postfix
    GFG Link :- https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
 */




// Approch 1

class Solution {
    public static int checkPrecedence(char ch){
        if(ch == '^') return 3;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '+' || ch == '-') return 1;
        
        return -1;
    }
    public static boolean checkOperator(char ch){
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }
    public static String infixToPostfix(String s) {
        int n = s.length(); 
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            
            // operand
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }
            else if(ch == '(' || ch == '[' || ch == '{'){ // open brackets
                st.push(ch);
            }
            else if(ch == ')' || ch == ']' || ch == '}'){ // close brackets
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }
                st.pop();
            }
            else if(checkOperator(ch)){
                
                while(!st.isEmpty() && checkPrecedence(st.peek()) > checkPrecedence(ch)){
                    ans.append(st.pop());
                }
                
                while(!st.isEmpty() && checkPrecedence(st.peek()) == checkPrecedence(ch) && ch != '^'){
                    ans.append(st.pop());
                }
                
                st.push(ch);
            }
            
        }
        
        

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
        return ans.toString();
    }
}