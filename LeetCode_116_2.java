/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        
        q.offer(root);
        q.offer(null);
        
        TreeLinkNode cur = new TreeLinkNode(-1);
        
        while(true){
            cur = q.poll();
            
            if(cur != null){
                cur.next = q.peek();
                if(cur.left != null){
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
            else{
                if(q.isEmpty())return;
                q.offer(null);
            }
        }
    }
}