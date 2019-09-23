/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 新建一个结果链表头dummy，然后cur指向这个res头
 初始化进位carry，数字之和sum
 
 进入while，只要l1和l2有一个不为null，就可以继续循环
 每次循环判断一下两个数字是什么
    digit1是：如果l1不为空，那么就是l1.val，为空就是0
    digit2是：如果l2不为空，那么就是l2.val，为空就是0
    
    当前和就是sum = digit1+digit2+carry
    然后sum如果大于10的话就carry=1
    
    此时新建一个节点，节点值为sum%10，然后cur后移
    
    然后判断l1和l2能否后移，能的话后移

退出循环后，看carry是不是1，是的话还要新建一个节点为1

最后返回dummy.next
 
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        int carry = 0, sum = 0;
        
        while (l1 != null || l2 != null) {
            int digit1 = l1 == null ? 0 : l1.val;
            int digit2 = l2 == null ? 0 : l2.val;
            
            sum = digit1 + digit2 + carry;
            carry = sum >= 10 ? 1 : 0;
            
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry == 1)
            cur.next = new ListNode(1);
        
        return dummy.next; 
    }
}
