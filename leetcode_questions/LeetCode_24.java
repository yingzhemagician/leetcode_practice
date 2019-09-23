/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 画图就好想了
 建立dummy头，然后cur指向dummy，也就是每次被交换的pair的前一个，然后交换next，最后cur蹦到下一对pair的前一个，也就是temp.next的位置
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        
        while(cur.next != null && cur.next.next != null){
            ListNode temp = cur.next.next;
            cur.next.next = temp.next;
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        
        return dummy.next;
    }
}
