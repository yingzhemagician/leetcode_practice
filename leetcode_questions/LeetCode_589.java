/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
就是递归先序遍历，还没写非递归，非递归用栈
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        
        preorderTraverse(root, res);
        return res;
    }
    
    private void preorderTraverse(Node root, List<Integer> res){
        if(root == null) return;
        
        res.add(root.val);
        for(Node child : root.children){
            preorderTraverse(child, res);
        }
    }
}
