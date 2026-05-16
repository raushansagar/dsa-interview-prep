/*
    Serialize and De-serialize BT
    Leetcode Link :- https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
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




public class Codec {

    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            while(size--> 0){
                TreeNode curr = q.remove();

                if(curr == null){
                    s.append("null,");
                }
                else{
                    s.append(curr.val+",");
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }


        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        if(str[0].equals("null")) return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        int idx = 1;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            while(size--> 0){
                TreeNode curr = q.remove();

                if(str[idx].compareTo("null") != 0){
                    curr.left = new TreeNode(Integer.parseInt(str[idx]));
                    q.add(curr.left);
                }
                
                idx++;

                if(str[idx].compareTo("null") != 0){
                    curr.right = new TreeNode(Integer.parseInt(str[idx]));
                    q.add(curr.right);
                }

                idx++;
            }
        }

        return root;
    }
}
