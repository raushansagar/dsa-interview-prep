

/*
    85. Maximal Rectangle
    Leetcode Link :- https://leetcode.com/problems/maximal-rectangle/description/
*/



// Approch 1
// Time complexity O(n * m) 

class Solution {
    public int[] getNSL(int[] arr, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek(); 
            st.push(i);
        }

        return ans;
    }
    public int[] getNSR(int[] arr, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek(); 
            st.push(i);
        }

        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];
        int ans = 0;
        
        // O(n)
        for(int i = 0; i < n; i++){

            // O(m)
            for(int j = 0; j < m; j++){
                height[j] = matrix[i][j] == '0' ? 0 : (height[j] + 1);
            }

            // O(m)
            int[] NSL = getNSL(height, m);
            int[] NSR = getNSR(height, m);

            // O(m)
            for(int k = 0; k < m; k++){
                int w = (k - NSL[k] - 1) + (NSR[k] - k - 1) + 1;
                int l = height[k];
                int area = w * l;
                ans = Math.max(ans, area);
            }
        }
        

        return ans;
    }
}