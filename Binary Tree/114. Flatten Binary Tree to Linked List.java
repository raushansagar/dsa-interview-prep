/*
    114. Flatten Binary Tree to Linked List
    Leetcode Link :- https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
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
    public void flatten(TreeNode curr) {
        if(curr == null) return;

        while(curr != null){

            if(curr.left == null){
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                
                prev.right = curr.right;

                // delete node
                curr.right = curr.left;
                curr.left = null;
            }
        }

    }
}