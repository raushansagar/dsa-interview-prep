/*
    Bottom View of Binary Tree
    GFG Link https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
*/




/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/



class Solution {
    static class Pair{
        Node root;
        int idx;
        
        Pair(Node node, int idx){
            this.root = node;
            this.idx = idx;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            
            Node curr = p.root;
            int idx = p.idx;
            
            map.put(idx, curr.data);
            
            if(curr.left != null){
                q.add(new Pair(curr.left, idx-1));
            }
            if(curr.right != null){
                q.add(new Pair(curr.right, idx+1));
            }
        }
        
        for(int key : map.keySet()){
            ans.add(map.get(key));
        }
        
        return ans;
    }
}