



/*
    105. Construct Binary Tree from Preorder and Inorder Traversal
    leetcode link :- https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
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
    int idx = 0;
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

        idx++;
        root.left = solve(preorder, inorder, si, pos-1);
        root.right = solve(preorder, inorder, pos+1, ei);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, preorder.length-1);
    }
}