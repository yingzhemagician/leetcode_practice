/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null){
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        
        //find the mid
        ListNode fast = head, slow = head, pre = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        
        if(fast == head && fast.next != null) slow = slow.next;
        
        //split the list
        pre.next = null;
        ListNode secondHead = slow.next;
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(secondHead);
        
        return root;
    }
}