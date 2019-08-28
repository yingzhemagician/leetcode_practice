/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 就是层序遍历
 然后把当前层的tempList放在res的首尾
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null) return res;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            List<Integer> tempList = new LinkedList<Integer>();
            
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
                
                tempList.add(cur.val);
            }
            res.add(0, tempList);
        }
        return res;
    }
}
