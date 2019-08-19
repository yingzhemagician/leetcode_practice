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
 
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int sum = 0;
        
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
        
        // while(l2 != null){
        //     s2.push(l2.val);
        //     l2 = l2.next;
        // }
        // head的下一个结点为curNode
        ListNode curNode = new ListNode(0);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();
            
            // head.val存储进制位，head.val可能为0
            ListNode head = new ListNode(sum/10);
            
            // curNode存储结果
            curNode.val = sum % 10;
            head.next = curNode;
            // curNode往前移动，指向head
            curNode = head;
            
            // 此时sum存储的是进制位
			// 下次计算需要用到
            sum /= 10;
        }
        
        // 前导0的情况,
		// curNode为head的引用，可能为0
        if (curNode.val == 0)
			curNode = curNode.next;
		return curNode;

        
    }
}
