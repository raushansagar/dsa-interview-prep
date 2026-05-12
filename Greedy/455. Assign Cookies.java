/*
    455. Assign Cookies
    leetcode link :- https://leetcode.com/problems/assign-cookies/description/
 */


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(s);

        for(int i = 0; i < g.length; i++){
            for(int j = 0; j < s.length; j++){
                if(s[j] >= g[i]){
                    s[j] = -1;
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}