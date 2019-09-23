/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 递归法
 判断l1和l2合法性之后，新建一个mergeHead引用，然后比较当前l1的值和l2的值
    如果l1小，那mergeHead应该是l1，那么mergeHead.next就是下一次递归的值merge(l1.next,l2)
    
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode mergeHead = null;
        
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}

// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if (l1 == null && l2 == null) return null;
//         if (l1 == null) return l2;
//         if (l2 == null) return l1;
        
//         ListNode cur = null;
        
//         if (l1.val < l2.val) {
//             cur = l1;
//             l1 = l1.next;
//         } else {
//             cur = l2;
//             l2 = l2.next;
//         }
//         ListNode mergeHead = cur;
        
//         while (l1 != null || l2 != null) {
//             if ((l1 != null && l2 != null && l1.val < l2.val) || (l1 != null && l2 == null)) {
//                 cur.next = l1;
//                 l1 = l1.next;
//             } else if (l2 != null) {
//                 cur.next = l2;
//                 l2 = l2.next;
//             }
            
//             cur = cur.next;
//         }
        
//         cur.next = null;
        
//         return mergeHead;
//     }
// }
