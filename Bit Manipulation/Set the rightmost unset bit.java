/*
    Set the rightmost unset bit
    GFG Link :- https://www.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1
*/


class Solution {
    static int setBit(int n) {
        return n | (n+1);
    }
}