/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null) return res;
        
        levelOrder(root, res, 1);
        
        return res;
    }
    
    public void levelOrder(TreeNode root, List<List<Integer>> res, int level){
        if(root == null) return;
        
        if(level > res.size())
            res.add(new ArrayList<Integer>());
        
        if(level % 2 != 0)
            res.get(level-1).add(root.val);
        else
            res.get(level-1).add(0, root.val);
        
        levelOrder(root.left, res, level + 1);
        levelOrder(root.right, res, level + 1);
    }
    
}