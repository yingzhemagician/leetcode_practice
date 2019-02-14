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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;
        if(postorder == null || postorder.length == 0) return null;
        if(inorder.length != postorder.length) return null;
        
        return build(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }
    
    public int getIndexInInorder(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) 
            if (val == inorder[i]) 
                return i;
        return -1;
    }
    
    public TreeNode build(int[] inorder, int[] postorder, int rootIdx, int start, int end){
        if(start > end) return null;
        
        TreeNode node = new TreeNode(postorder[rootIdx]);
        
        int index = getIndexInInorder(inorder, postorder[rootIdx]);
        
        int lenL = index - start;
        int lenR = end - index;
        
        if(lenL > 0)
            node.left = build(inorder, postorder, rootIdx - 1 - lenR, start, index-1);
        if(lenR > 0)
            node.right = build(inorder, postorder, rootIdx - 1, index+1, end);
        
        return node;
    }
}