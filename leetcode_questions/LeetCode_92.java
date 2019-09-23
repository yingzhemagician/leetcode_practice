/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
指定位置翻转链表
跟普通翻转链表一样，首先建一个dummy头，这避免了如果头结点在翻转范围里的情况
然后，设一个pre指针，从dummy头开始走，走m-1步，走到翻转范围的前一个，然后pre就不在动了.
然后按照easy版里那么左，partRear其实就是easy里dummy的next，也就是null
partRear的下一个才是要拆下来操作的数
。pre其实就是easy版本里的dummy
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        
        for(int i = 1; i <= m-1; i++)
            pre = pre.next;
        
        ListNode partRear = pre.next;
        ListNode cur = partRear.next;
        
        for(int i = 1; i <= n-m; i++){
            partRear.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = partRear.next;
        }
        
        return dummy.next;
    }
}
