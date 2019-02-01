/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null) return null;
        if(k == 0) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode fast = head, slow = head;
        int len = 1;
        
        while(fast.next != null){
            fast = fast.next;
            len++;
        }
        
        if(k == len) return head;
        int newK = k % len;
        
        if(newK == 0) return head;
        
        for(int i = 1; i < len - newK; i++){
            slow = slow.next;
        }
        
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        
        return dummy.next;
    }
}