/*
    2144. Minimum Cost of Buying Candies With Discount
 */



class Solution {
    public int minimumCost(int[] cost) {

        int n = cost.length;
        Arrays.sort(cost);

        int idx = n-1;
        int minCost = 0;

        while(idx >= 0){
            if((idx-1) >= 0){
                minCost += cost[idx] + cost[idx-1];
                idx -= 3;
            }
            else{
                break;
            }
        }

        while(idx >= 0){
            minCost += cost[idx];
            idx--;
        }
        

        return minCost;
    }
}