/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 其实就是算深度，算深度的同时记录直径，也就是某个点的左右子树深度的和，深度是2的话路径就是1
 
 递归中，先算左子树深度，再算右子树深度，左右子树深度相加就是这个节点的半径，和res比一下选大的
 递归返回当前节点的树的深度，所以选左右子树深度大的那个，再加1
 */
class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        deepOfTree(root);
        
        return res;
    }
    
    private int deepOfTree(TreeNode node){
        if(node == null) return 0;
        int left = deepOfTree(node.left);
        int right = deepOfTree(node.right);
        
        res = Math.max(res, left+right);
        
        return Math.max(left, right)+1;
    }
}
