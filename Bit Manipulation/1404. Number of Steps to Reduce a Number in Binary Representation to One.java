/*
    1404. Number of Steps to Reduce a Number in Binary Representation to One
    Leetcode Link :- https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
 */



// Approch 1
// Time complexity O(n^2)

class Solution {
    public String addOne(String s){
        int i = s.length()-1;

        while(i >= 0){
            if(s.charAt(i) == '0'){
                s = s.substring(0, i) + '1' + s.substring(i+1, s.length());
                break;
            }
            else{
                s = s.substring(0, i) + '0' + s.substring(i+1, s.length());
            }

            i--;
        }

        if(i <= 0){
            s = '1'+s;
        }

        return s;
    }
    public int numSteps(String s) {
        int op = 0;

        while(s.length() > 1){
            int n = s.length()-1;

            if(s.charAt(n) == '1'){
                s = addOne(s);
                op++;
            }
            else{
                s = s.substring(0, s.length()-1);
                op++;
            }
        }

        return op;
    }
}


// Approch 2
// Time complexity O(n)


class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int op = 0;

        for(int i = s.length()-1; i >= 1; i--){
            if((s.charAt(i)-'0')+carry == 1){
                op += 2;
                carry = 1;
            }
            else{
                op++;
            }
        }

        return op + carry;
    }
}