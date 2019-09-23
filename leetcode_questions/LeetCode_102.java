/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 建立res，检查root的合法性
 建立队列queue用于层序遍历
    while中先获取当前层的size
        然后建立tempList记录当前层的序列
        for循环遍历当前层，长度就是刚才的size
            弹出队首，把它的值加入tempList
            如果有左右孩子，就都offer进队列
        退出for的时候把tempList加入res
        
        
DFS也可以做，就是每遍历新的一层就建一个新的list，然后后面回到这层是再取出这层的List往里面加东西
 */
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> res = new LinkedList<List<Integer>>();
//         if(root == null) return res;
        
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.offer(root);
        
//         while(!queue.isEmpty()){
//             int qsize = queue.size();
//             List<Integer> tempList = new LinkedList<Integer>();
            
//             for(int i = 0; i < qsize; i++){
//                 TreeNode curNode = queue.poll();
                
//                 tempList.add(curNode.val);
                
//                 if(curNode.left != null)  queue.offer(curNode.left);
//                 if(curNode.right != null)  queue.offer(curNode.right);
//             }
//             res.add(tempList);
//         }
//         return res;
//     }
// }


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, root, 1);
        return res;
    }
    public void helper(List<List<Integer>> res, TreeNode node, int curLevel){
        if (node == null) return;
        if (curLevel > res.size())
            res.add(new LinkedList<Integer>());
        
        res.get(curLevel-1).add(node.val);
        
        helper(res, node.left, curLevel + 1);
        helper(res, node.right, curLevel + 1);
    }
}
