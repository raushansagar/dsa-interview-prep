/*  
    84. Largest Rectangle in Histogram
    Leetcode Link :- 
 */



// Approch 1
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
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] NSL = new int[n];
        int[] NSR = new int[n];

        NSL = getNSL(heights, n);
        NSR = getNSR(heights, n);

        int ans = 0;
        for(int i = 0; i < n; i++){
            int w = (i - NSL[i] - 1) + (NSR[i] - i - 1) + 1;
            int l = heights[i];
            int area = w * l;
            ans = Math.max(area, ans);
        }


        return ans;
    }
}