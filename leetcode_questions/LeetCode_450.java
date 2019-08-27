/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 经典题，可以反复看
 思路就是先在BST里查找该节点，找到后，把右子树的最小节点放过来，然后右边递归删除这个最小点
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                TreeNode minOfRight = findMin(root.right);
                root.val = minOfRight.val;
                root.right = deleteNode(root.right, minOfRight.val);
            }
        }
        
        return root;
    }
    
    private TreeNode findMin(TreeNode root){
        if(root.left == null) return root;
        return findMin(root.left);
    }
}
