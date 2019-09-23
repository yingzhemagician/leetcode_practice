/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
用hashmap来copy

map里存放 <原节点，新建的和原节点相同的节点>
所以第一次遍历LinkedList是为了把所有节点复制到map里，但是注意，此时map中的value是新的节点，但是新的节点里的next和random其实都是指向原来的链表中的节点，不是新建的

所以需要第二次遍历，第二次遍历每次取出cur的下一个点的新建节点，然后连在cur的新建节点的next上
random同理

最后返回map.get(head)，也就是head的新建节点
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        
        while(cur != null){
            map.put(cur, new Node(cur.val, cur.next, cur.random));
            cur = cur.next;
        }
        
        cur = head;
        
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
