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
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode cur = dummy;
        
        while(root != null){
            if(root.left != null){
                cur.next = root.left;
                cur = cur.next;
            }
            
            if(root.right != null){
                cur.next = root.right;
                cur = cur.next;
            }
            
            root = root.next;
            
            if(root == null){
                root = dummy.next;
                dummy.next = null;
                cur = dummy;
            }
        }
    }
}