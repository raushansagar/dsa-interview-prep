
/*
    Quick Sort
    GFG Link :- https://www.geeksforgeeks.org/problems/quick-sort/1
 */


class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if(low >= high){
            return;
        }
        
        int pat = partition(arr, low, high);
        
        quickSort(arr, low, pat-1);
        quickSort(arr, pat+1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pat = arr[high];
        int idx = low;
        
        for(int i = low; i < high; i++){
            if(arr[i] <= pat){
                // swap
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                idx++;
            }
        }
        
        int temp = arr[high];
        arr[high] = arr[idx];
        arr[idx] = temp;
        
        return idx;
    }
}