/*
    Frog Jump
*/




// Momoization + Top down 
class Solution {
    public int solve(int n, int[] height, int[] memo){
        if(n == 0) return 0;
        
        if(memo[n-1] != -1) return memo[n];
        
        int path1 = Math.abs(height[n]-height[n-1]) + solve(n-1, height, memo);
        int path2 = n > 1 ? Math.abs(height[n]-height[n-2]) + solve(n-2, height, memo) : Integer.MAX_VALUE;
        
        return memo[n] = Math.min(path1, path2);
    }
    int minCost(int[] height) {
        int n = height.length;
        
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        return solve(n-1, height, memo);
    }
}




// Buttom Up
class Solution {
    int minCost(int[] height) {
        
        int n = height.length;
        int[] memo = new int[n];
        
        for(int i = 1; i < n; i++){
            
            int path1 = Math.abs(height[i]-height[i-1]) + memo[i-1];
            int path2 = i > 1 ? Math.abs(height[i]-height[i-2]) + memo[i-2] : Integer.MAX_VALUE;
            
            memo[i] = Math.min(path1, path2);
        }
        

        return memo[n-1];
    }
}
