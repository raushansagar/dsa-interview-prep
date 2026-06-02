/*
    509. Fibonacci Number
 */






// Top Down + Memoization
class Solution {
    public int fibo(int n, int[] memo){
        if(n == 1) return 1;
        if(n == 0) return 0;

        if(memo[n] != -1) return memo[n];

        return memo[n] = fibo(n-1, memo) + fibo(n-2, memo);
    }
    public int fib(int n) {

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return fibo(n, memo);
    }
}




// Buttom up 
class Solution2 {
    public int fib(int n) {
        if(n <= 1) return n;

        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }
}
