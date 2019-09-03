/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 最小堆
 就是用PriorityQueue
 遍历lists里的所有list，把每个list里的每个int val都加到queue里自动排序
 然后再一个个输出连接成链表。。。
 
 假设每个list有n个点，建立堆是nk，poll每次是log(nk)
 所以总的就是kn+kn*log(kn)，应该是这样
 
 第二种做法为什么快一些呢
 */
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
//         for(int i = 0; i < lists.length; i++){
//             ListNode list = lists[i];
//             while(list != null){
//                 queue.add(list.val);
//                 list = list.next;
//             }
//         }
        
//         ListNode dummy = new ListNode(-1);
//         ListNode cur = dummy;
        
//         while(!queue.isEmpty()){
//             cur.next = new ListNode(queue.poll());
//             cur = cur.next;
//         }
//         return dummy.next;
//     }
// }

/*时间复杂度  k/2次乘2*n，k/4次乘2*2n，k/8次乘2*4n。。。。所以每项都是kn
  从k/2一直到最后一层合并，也就是说k除以多少个2才是1，所以是logk，一共有logk个kn所以O(nk*logk)

*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int start = 0, end = lists.length-1;
        while(start < end){
            while(start < end){
                lists[start] = merge(lists[start], lists[end]);
                start++;
                end--;
            }
            start = 0;
        }
        return lists[0];
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null? l2:l1;
        return dummy.next;
    }
}
