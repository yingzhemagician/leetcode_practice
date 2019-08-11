/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head){
        
        if(head == null || head.next == null) return head;
        
		ListNode dummy = new ListNode(-1) ;
        dummy.next = head;
		 
		ListNode pre = dummy;
		ListNode first = head;
		ListNode last = head.next;
        int flag = 1;
        
		while(last != null){
            if(last != null && last.val == first.val){
                last = last.next;
                flag = 0;
            }
            else{
                first = last;
                last = last.next;
                if(flag == 1) pre = pre.next;
                else pre.next = first;
                flag = 1;
            }
        }
        if(flag == 0)
            pre.next = last;
        return dummy.next;
    }
}