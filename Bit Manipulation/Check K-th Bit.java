/*
    Check K-th Bit
    GFG Link :- https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
 */



class CheckBit {
    static boolean checkKthBit(int n, int k) {
        
        while(k > 0){
            n = n >> 1;
            k--;
        }
        
        return (n & 1) == 1 ? true : false;
    }
}