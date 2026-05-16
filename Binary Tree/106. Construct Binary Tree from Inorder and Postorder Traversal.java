/*
    106. Construct Binary Tree from Inorder and Postorder Traversal
    Leetcode link :- https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/ 
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
    int idx;
    public TreeNode solve(int[] preorder, int[] inorder, int si, int ei){
        if(si > ei) return null;
        TreeNode root = new TreeNode(preorder[idx]);

        int pos = -1;
        for(int i = si; i <= ei; i++){
            if(inorder[i] == preorder[idx]){
                pos = i;
                break;
            }
        }

        idx--;
        root.right = solve(preorder, inorder, pos+1, ei);
        root.left = solve(preorder, inorder, si, pos-1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length-1;   
        idx = n;

        return solve(postorder, inorder, 0, n);
    }
}