/*
    1442. Count Triplets That Can Form Two Arrays of Equal XOR
    Leetcode Link :- https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
*/


// Approch 1
// Time complexity O(n^2)

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int result = 0;

        int[] prefix = new int[n+1];
        prefix[0] = 0;

        for(int i = 1; i < prefix.length; i++){
            prefix[i] = arr[i-1] ^ prefix[i-1];
        }

  

        for(int i = 0; i < prefix.length; i++){
            for(int k = i+1; k < prefix.length; k++){
                if(prefix[i] == prefix[k]){
                    result += k-i-1;
                }
            }
        }

        return result;
    }
}


// Approch 2
// Time compelxity O(n * k) k = no of prev elements

class Solution {
    public int countTriplets(int[] arr) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.putIfAbsent(0, new ArrayList<>());
        map.get(0).add(-1);

        int result = 0;

        int xor = 0;
        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];

            if(map.containsKey(xor)){
                List<Integer> list = map.get(xor);
                int lastIdx = list.get(list.size()-1);

                result += (i - lastIdx) * list.size(); 
            }

            map.putIfAbsent(xor, new ArrayList<>());
            map.get(xor).add(i);
        }


        return result;
    }
}


// Approch 3
// Time complexity O(n)

class Solution3{
    public int countTriplets(int[] arr) {
        Map<Integer, Integer> idxSum = new HashMap<>();
        Map<Integer, Integer> idxCount = new HashMap<>();
        idxSum.put(0, -1);
        idxCount.put(0, 1);
        
        int result = 0;
        int xor = 0;

        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];

            if(idxSum.containsKey(xor)){
                int count = idxCount.get(xor);
                int sum = idxSum.get(xor);

                result += (i * count) - sum - count;
            }

            idxSum.put(xor, idxSum.getOrDefault(xor, 0) + i);
            idxCount.put(xor, idxCount.getOrDefault(xor, 0) + 1);
        }



        return result;
    }
}