/*
    863. All Nodes Distance K in Binary Tree
    Leetcode Link :- https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
*/




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public void findAncestor(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map){
        if(root == null) return;

        map.put(root, parent);
        findAncestor(root.left, root, map);
        findAncestor(root.right, root, map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode parent = new TreeNode(-1);
        findAncestor(root, parent, map);

        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(target);
        set.add(parent);
        int level = 0;

        while(!q.isEmpty() && level <= k){
            int size = q.size();

            while(size--> 0){
                TreeNode curr = q.remove();
                if(set.contains(curr)) continue;

                set.add(curr);
                if(level == k) ans.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(map.containsKey(curr)) q.add(map.get(curr));
            }

            level++;
        }


        return ans;
    }
}