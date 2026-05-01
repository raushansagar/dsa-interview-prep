

/*
    146. LRU Cache
    Leetcode Link :- https://leetcode.com/problems/lru-cache/description/
*/


// Approch 1
// Time complxity O(1)

class LRUCache {
    static class Node{
        int[] val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.val = new int[]{key, val};
        }
    }

    Node head;
    Node tail;

    int size = 0;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int cap) {
        map = new HashMap<>();
        capacity = cap;
    }

    // remove node
    public void remove(Node list){
        if(list.prev != null){
            list.prev.next = list.next;
        }
        else{
            head = list.next;
        }

        if(list.next != null){
            list.next.prev = list.prev;
        }
        else{
            tail = list.prev;
        }
    }

    // insert node
    public void insert(Node node){
        if(head == null){
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }

    // get key val
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node temp = map.get(key);

        remove(temp);
        insert(temp);
        
        return temp.val[1];
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val[1] = value;
            remove(node);
            insert(node);
        }
        else{
            Node newNode = new Node(key, value);
            insert(newNode);
            map.put(key, newNode);
            size += 1;

            if(size > capacity){
                map.remove(head.val[0]);
                remove(head);
                size -= 1;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */