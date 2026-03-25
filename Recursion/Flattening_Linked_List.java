/*
    Flattening a Linked List
    GFG Link :- https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
 */




/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node mergeLL(Node l1, Node l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        Node result;
        if(l1.data < l2.data){
            result = l1;
            result.bottom = mergeLL(l1.bottom, l2);
        }
        else{
            result = l2;
            result.bottom = mergeLL(l1, l2.bottom);
        }
        
        return result;
    }
    public Node flatten(Node root) {
        if(root == null) return null;
        
        Node head = flatten(root.next);
        root.next = null;
        
        return mergeLL(root, head);
    }
}