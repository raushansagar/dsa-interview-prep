/*
    987. Vertical Order Traversal of a Binary Tree
    Leetcode Link :- https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 */




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair{
        int row;
        int col;
        int val;

        Pair(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public void solve(TreeNode root, int row, int col, List<Pair> list){
        if(root == null) return;
        list.add(new Pair(row, col, root.val));

        solve(root.left, row+1, col-1, list);
        solve(root.right, row+1, col+1, list); 
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Pair> list = new ArrayList<>();

        solve(root, 0, 0, list);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]){
                if(a[0] == b[0]){
                    return a[2] - b[2];
                }

                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        // O (log n)
        for(Pair p : list){
            pq.add(new int[]{p.row, p.col, p.val});
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        // O (log n)
        while(!pq.isEmpty()){
            int[] temp = pq.remove();

            // O (log n)
            map.putIfAbsent(temp[1], new ArrayList<>());
            map.get(temp[1]).add(temp[2]);
        }
        
        // O (log n)
        for(int key : map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}