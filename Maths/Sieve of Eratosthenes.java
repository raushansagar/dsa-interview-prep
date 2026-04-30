/*
    Primality Check  |  Sieve of Eratosthenes
    GFG Link :- https://www.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1
*/




// Check Prime 
// Time complexity O(root n)

public static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        
        for(int fact = 2; fact <= (int)Math.sqrt(n); fact++){
            if(n%fact == 0){
                return false;
            }
        }
        
        return true;
    }





// Find Prime in range
// Time compleixity O(log (logn n))


class Solution {
    public int[] sieve(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        
        List<Integer> list = new ArrayList<>();
        prime[0] = false;
        prime[1] = false;
        
        for(int i = 2; i*i <= n; i++){
            if(prime[i]){
                for(int j = i; i*j <= n; j++){
                    prime[i*j] = false;
                }
            }
        }
        
        for(int i = 0; i <= n; i++){
            if(prime[i]) list.add(i);
        }
        
        int[] ans = new int[list.size()];
        int idx = 0;
        
        for(int val : list) ans[idx++] = val;
        
        return ans;
    }
}