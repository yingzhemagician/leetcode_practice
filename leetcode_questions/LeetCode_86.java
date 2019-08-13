/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lhead = new ListNode(-1);
        ListNode ghead = new ListNode(-1);
        
        ListNode cur = head, gcur = ghead, lcur = lhead;
        
        while(cur != null){
            if(cur.val >= x){
                gcur.next = cur;
                gcur = gcur.next;
            }
            else{
                lcur.next = cur;
                lcur = lcur.next;
            }
            cur = cur.next;
        }
        
        lcur.next = ghead.next;
        gcur.next = null;
        
        return lhead.next;
    }
}