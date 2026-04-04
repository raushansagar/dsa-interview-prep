public class 201. Bitwise AND of Numbers Range {
    
}

// Approch 1
// Time compelxity O(n) n = right-left+1

class Solution1 {
    public int rangeBitwiseAnd(int left, int right) {
        int result = 1;

        for(int i = left+1; i <= right; i++){
            result = result & i;
        }

        return result;
    }
}



// Approch 2
// Time compelxity O(1)    no of bit 32
 
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        while(left != right){
            left = left >> 1;
            right = right >> 1;

            shift++;
        }

        return left << shift;
    }
}


// Approch 3
// Time compelxity O(k)  k = no of set bit

class Solution3{
    public int rangeBitwiseAnd(int left, int right) {
        
        while(right > left){
            right = right & (right-1);
        }

        return right;
    }
}