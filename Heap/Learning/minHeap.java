package Heap.Learning;


import java.util.*;



// Implement min Heap

class Heap{

    static ArrayList<Integer> hp = new ArrayList<>();

    // add O(log n)
    public static  void add(int val){

        // step 1;
        hp.add(val);
        
        // fix parent
        int idx = hp.size()-1;
        int parIdx = (idx-1)/2;

        while(idx > 0 && hp.get(parIdx) > hp.get(idx) ){

            // swap
            int temp = hp.get(idx);
            hp.set(idx, hp.get(parIdx));
            hp.set(parIdx, temp);

            idx = parIdx;
            parIdx = (idx-1)/2;
        }

    }

    // peek O(1)
    public static  int peek(){
        if(hp.isEmpty()) return -1;

        return hp.get(0);
    }

    // delete O(log n)
    public static int remove(){
        if(hp.isEmpty()) return -1;

        // step 1
        int val = hp.get(0);

        // step 2 swap
        int temp = hp.get(0);
        hp.set(0, hp.get(hp.size()-1));
        hp.set(hp.size()-1, temp);

        // setp 3 delete
        hp.remove(hp.size()-1);

        // step 4 fix all child & call heapify
        heapify(0);

        return val;
    }
    public static  void heapify(int i){

        int leftIdx = 2*i + 1;
        int rightIdx = 2*i + 2;
        int minIdx = i;

        if(leftIdx < hp.size() && hp.get(leftIdx) < hp.get(minIdx)){
            minIdx = leftIdx;
        }

        if(rightIdx < hp.size() && hp.get(rightIdx) < hp.get(minIdx)){
            minIdx = rightIdx;
        }

        if(minIdx != i){

            // swap
            int temp = hp.get(minIdx);
            hp.set(minIdx, hp.get(i));
            hp.set(i, temp);

            heapify(minIdx);
        }
    }

    // isEmpty
    public static boolean isEmpty(){
        return hp.isEmpty();
    }
    public static void main(String[] args) {
        add(8);
        add (4);
        add(1);
        add(10);

        while(!isEmpty()){
            System.out.println(peek());
            remove();
        }
    }
}
