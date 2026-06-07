/*
    2196. Create Binary Tree From Descriptions
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
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] d : descriptions){

            int parentVal = d[0];
            int childVal = d[1];
            boolean left = d[2] == 1;

            map.putIfAbsent(childVal, new TreeNode(childVal));
            map.putIfAbsent(parentVal, new TreeNode(parentVal));

            TreeNode child = map.get(childVal);
            TreeNode parent = map.get(parentVal);

            if(left){
                parent.left = child;
            }
            else{
                parent.right = child;
            }

            children.add(childVal);
        }

        for(int key : map.keySet()){
            if(!children.contains(key)) return map.get(key);
        }

        return null;
    }
}