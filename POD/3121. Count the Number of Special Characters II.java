
/*
    3121. Count the Number of Special Characters II
 */

class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        Arrays.fill(freq1, -1);
        Arrays.fill(freq2, -1);

        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                freq1[ch-'a'] = i;
            }
            else if(ch >= 'A' && ch <= 'Z' && freq2[ch-'A'] == -1){
                freq2[ch-'A'] = i;
            }
        }

        int count = 0;
        for(int i = 0; i < 26; i++){
            if(freq1[i] != -1 && freq2[i] != -1 && freq1[i] < freq2[i]){
                count++;
            }
        }
        
        
        return count;
    }
}