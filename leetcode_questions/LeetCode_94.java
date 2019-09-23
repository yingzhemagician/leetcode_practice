/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 递归与非递归
 非递归就是用栈，左左左这样把所有左孩子先放进栈，然后弹出一个作为根，写进res，然后下一次循环的node就是当前node的right。
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        
        return res;
    }
    
    private void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        if(root.left != null) inorder(root.left, res);
        
        res.add(root.val);
        
        if(root.right != null) inorder(root.right, res);
    }
}


// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         List<Integer> res = new ArrayList<>();
//         TreeNode node = root;
        
//         while(!stack.isEmpty() || node != null){
//             while(node != null){
//                 stack.push(node);
//                 node = node.left;
//             }
            
//             node = stack.pop();
//             res.add(node.val);
//             node = node.right;
//         }
        
//         return res;
//     }
// }
