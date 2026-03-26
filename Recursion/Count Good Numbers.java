/*
    1922 Count Good Numbers
    Leetcode Link :- https://leetcode.com/problems/count-good-numbers/description/
 */

// Approch 1
// Time complexity O(n)

class Solution1 {
    int mod = 1000000007;
    public long solve(long n, String sign){
        if(n < 1) return 1;
        else if(n == 1 && sign.equals("even")){
            return 5;
        }
        else if(n == 1 && sign.equals("odd")){
            return 4;
        }

        return  ((sign.equals("even") ? 5 : 4) * solve(n-1, sign)) % mod;
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n/2);

        long evenGoodNum = solve(even, "even");
        long oddGoodNum = solve(odd, "odd");
        long result = (evenGoodNum * oddGoodNum) % mod;

        return (int)(result);
    }
}



// Approch 2
// Time complexity O(log n)


class Solution {
    int mod = 1000000007;
    public long solveEven(long n){
        if(n < 1) return 1;
        if(n == 1) return 5;

        long half = solveEven(n/2);
        if(n%2 == 1){
            return (5 * half * half) % mod;
        }
        return (half * half) % mod;
    }
    public long solveOdd(long n){
        if(n < 1) return 1;
        if(n == 1) return 4;

        long half = solveOdd(n/2);
        if(n%2 == 1){
            return (4 * half * half) % mod;
        }
        else{
            return (half * half) % mod;
        }
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n/2);

        long evenGoodNum = solveEven(even);
        long oddGoodNum = solveOdd(odd);

        long result = (evenGoodNum * oddGoodNum) % mod;
        return (int)(result);
    }
}