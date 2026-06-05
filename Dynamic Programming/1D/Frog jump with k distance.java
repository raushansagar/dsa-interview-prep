



    
/*


 */


// Top down approch 
class Solution {
    public int solve(int n, int[] heights, int k, int[] memo) {
        if (n == 0) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }
        int path = Integer.MAX_VALUE;

        for (int step = 1; step <= k; step++) {
            if (n - step < 0) {
                continue;
            }

            int currPath = Math.abs(heights[n] - heights[n - step]) + solve(n - step, heights, k, memo);
            path = Math.min(currPath, path);
        }

        return memo[n] = path;
    }

    public int frogJump(int[] heights, int k) {

        int n = heights.length;
        int[] memo = new int[n];

        Arrays.fill(memo, -1);

        return solve(n - 1, heights, k, memo);
    }

}


// buttom up approch 
class Solution {
    public int frogJump(int[] heights, int k) {

        int n = heights.length;
        int[] memo = new int[n];

        for(int i = 1; i < n; i++){
            int path = Integer.MAX_VALUE;

            for(int step = 1; step <= k; step++){
                if(i-step < 0) continue;

                int currPath = memo[i-step] + Math.abs(heights[i]-heights[i-step]);
                path = Math.min(path, currPath);
            }

            memo[i] = path;
        }

        return memo[n-1];
    }
}