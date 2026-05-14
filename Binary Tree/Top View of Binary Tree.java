/*
    Top View of Binary Tree
    GFG Link :- https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
*/



/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
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
    public ArrayList<Integer> topView(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            
            Node curr = p.root;
            int idx = p.idx;
            
            if(!map.containsKey(idx)) map.put(idx, curr.data);
            
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