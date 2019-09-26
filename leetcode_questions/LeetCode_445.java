/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 用栈
 先把两个链表都放到栈里，然后每次分别弹出一个，和sum相加，sum一开始是0，后来就是记录着上一次计算的进位
 
 每次维持一个curNode，然后新建一个head记录下进位，刨去进位的计算结果放在curNode里面，head.next指向curNode
 curNode移动到head，sum变成刚才的进位
 
 还有方法是reverse两个链表，然后相加，再reverse
 
 还有方法是先算链表长度，然后把短的链表补齐，然后递归去求每一位的和
 
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null || l2 != null){
            if(l1 != null){
                s1.push(l1.val);
                l1 = l1.next;
            }
            if(l2 != null){
                s2.push(l2.val);
                l2 = l2.next;
            }
        }

        // head的下一个结点为curNode
        ListNode head = new ListNode(-1);
        int carry = 0, sum = 0;
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();
            sum += carry;

            ListNode curNode = new ListNode(sum%10);
            curNode.next = head.next;
            head.next = curNode;
            
            carry = sum / 10;
            sum = 0;
        }
        
        if(carry == 1){
            ListNode node = new ListNode(1);
            node.next = head.next;
            head.next = node;
        }
            
		return head.next;
    }
}
