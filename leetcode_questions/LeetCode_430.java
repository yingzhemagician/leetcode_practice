/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
复习：
思路是，遍历链表，直到遇到了有child的点，然后新建childTail和child重合，用childTail找到当前的末尾
将当前的子列铺平，然后cur继续往后
难点主要是各个指针的赋值
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node cur = head;
        
        while(cur != null){
            if(cur.child == null){
                cur = cur.next;
                continue;
            }
            
            Node child = cur.child;
            Node childTail = child;
            
            while(childTail.next != null)
                childTail = childTail.next;
            
            cur.child = null;
            child.prev = cur;
            childTail.next = cur.next;
            
            if(cur.next != null)
                cur.next.prev = childTail;
            
            cur.next = child;
            cur = cur.next;
        }
        
        return head;
    }
}
