/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 直接递归，参数意思是当前节点，和到达当前节点前剩余的sum
 如果当前节点是空，直接返回
 如果当前节点的值和sum一样，且当前节点没有孩子，就是true
 如果都不是，就把当前节点的val减去，再递归
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        
        if (sum == root.val && root.left == null && root.right == null)
            return true;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
