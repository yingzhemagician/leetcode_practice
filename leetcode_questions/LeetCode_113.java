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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null) return res;
        
        int tempSum = 0;
        List<Integer> temp = new ArrayList<Integer>();
        
        DFS(root, tempSum + root.val, sum, temp, res);
        
        return res;
    }
    
    public void DFS(TreeNode root, int tempSum, int sum, List<Integer> temp, List<List<Integer>> res){
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(tempSum == sum)
                res.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return;
        }
        
        if(root.left != null){
            DFS(root.left, tempSum + root.left.val, sum, temp, res);
        }
        
        if(root.right != null){
            DFS(root.right, tempSum + root.right.val, sum, temp, res);
        }
        
        temp.remove(temp.size()-1);
    }
}