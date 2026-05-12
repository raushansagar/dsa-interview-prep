/*
    Fractional Knapsack
    GFG Link :- https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 */



class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));
        
        for(int i = 0; i < n; i++){
            pq.add(new double[]{ val[i], wt[i], ((double)val[i]/wt[i])});
        }
        
        double ans = 0;
        while(!pq.isEmpty()){
            
            double[] temp = pq.remove();
            double profit = temp[0];
            int weg = (int)temp[1];

            if(capacity == 0) break;

            if(capacity >= weg){
                ans += profit;
                capacity -= weg;
            }
            else{
                ans += profit * (1.0 * capacity/weg);
                capacity = 0;
            }
        }
        
        
        return ans;
    }
}