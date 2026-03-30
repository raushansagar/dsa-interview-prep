/*
    Odd or Even
    GFG Link :- https://www.geeksforgeeks.org/problems/odd-or-even3618/1
*/


class Solution {
    static boolean isEven(int n) {
        return (n & 1) == 1 ? false : true;
    }
}