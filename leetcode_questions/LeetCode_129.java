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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null) return 0;
        sum = helper(root, 0, 0);
        
        return sum;
    }
    
    public int helper(TreeNode root, int tempNum, int sum){
        if(root.left == null && root.right == null){
            sum += tempNum * 10 + root.val;
            return sum;
        }
        
        if(root.left != null) 
            sum = helper(root.left, tempNum * 10 + root.val, sum);
        if(root.right != null)
            sum = helper(root.right, tempNum * 10 + root.val, sum);
        
        return sum;
        
    }
}