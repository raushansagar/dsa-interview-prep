/*
    3161. Block Placement Queries
*/





class Solution {
    public List<Boolean> getResults(int[][] queries) {

        List<Boolean> ans = new ArrayList<>();

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for(int[] d : queries){
        
            // queries 1
            if(d[0] == 1){
                int x = d[1];
                set.add(x);
                continue;
            }
            

            // queries 2
            int x = d[1];
            int size = d[2];

            boolean result = false;
            int prev = 0;

            for(int curr : set){

                if(curr > x) break;
                int currSize = curr - prev;

                if(size <= currSize){
                    result = true;
                    break;
                }

                prev = curr;
            }

            if(!result && size <= (x - prev)){
                result = true;
            }

            ans.add(result);
        }


        return ans;
    }
}