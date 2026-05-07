

/*
    23. Merge k Sorted Lists
    Leetcode Link :- https://leetcode.com/problems/merge-k-sorted-lists/description/
 */



// Approch 1

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node : lists){
            while(node != null){
                ListNode temp = node;
                node = node.next;

                temp.next = null;
                pq.add(temp);
            }
        }


        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.remove();

            ans.next = node;
            ans = node;
        }


        return dummy.next;
    }
}