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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        if(inorder == null || inorder.length == 0) return null;
        if(preorder.length != inorder.length) return null;
        
        return build(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    public int getIndexInInorder(int[] inorder, int val){
        for (int i = 0; i < inorder.length; i++)
            if (val == inorder[i])
                return i;

        return -1;
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int rootIdx, int start, int end){
        if(start > end) return null;
        
        TreeNode node = new TreeNode(preorder[rootIdx]);
        
        int index = getIndexInInorder(inorder, preorder[rootIdx]);
        
        int lenL = index - start;
        int lenR = end - index;
        
        if(lenL > 0)
            node.left = build(preorder, inorder, rootIdx+1, start, index-1);
        if(lenR > 0)
            node.right = build(preorder, inorder, rootIdx+lenL+1, index+1, end);
        
        return node;
    }
}