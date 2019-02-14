public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }
    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}