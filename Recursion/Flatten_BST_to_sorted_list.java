
/*
    Flatten BST to sorted list
    GFG Link :- https://www.geeksforgeeks.org/problems/flatten-bst-to-sorted-list--111950/1
 */




    

/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node flattenBST(Node root) {
        if(root == null) return null;
        
        Node leftHead = flattenBST(root.left);
        root.left = null;
        Node rightHead = flattenBST(root.right);
        
        if(leftHead != null){
            Node temp = leftHead;
            
            while(temp != null && temp.right != null){
                temp = temp.right;
            }
            
            temp.right = root;
            root.right = rightHead;
            return leftHead;
        }
        else{
            root.right = rightHead;
            return root;
        }
    }
}
