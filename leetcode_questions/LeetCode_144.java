/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 就是普通的先序 根左右遍历，因为每次递归都要传res所以新建一个递归方法
 递归进去就是看当前root是不是空，是的话直接return，不是的话先把root.val放到list里
 然后递归左孩子，再递归右孩子
 
 迭代法用栈，再用一个set作为visited
 然后放入root，开始循环
 先peek()出cur，不是pop()，然后把它看成root，如果这个root没visited，就放入res
    如果有左孩子且没访问过，就把左孩子入栈
    否则，看右孩子，有且没访问就入栈
    否则就pop()出cur
 */
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         preorder(root, res);
//         return res;
//     }
    
//     public void preorder(TreeNode root, List<Integer> res){
//         if(root == null) return;
        
//         res.add(root.val);
//         preorder(root.left, res);
//         preorder(root.right, res);
//     }
// }


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            
            if(!visited.contains(cur))
                res.add(cur.val);
            
            visited.add(cur);
            
            if(cur.left != null && !visited.contains(cur.left))
                stack.add(cur.left);
            else if(cur.right != null && !visited.contains(cur.right))
                stack.add(cur.right);
            else
                stack.pop();
        }
        return res;
    }
}
