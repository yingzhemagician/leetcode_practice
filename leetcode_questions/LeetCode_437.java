/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 方法一：DFS，从当前点开始DFS一下当前sum，得到一个值，加上从当前点的左右孩子开始从新找原来的sum，不太好想
 方法二：层序queue遍历二叉树每个节点，对每个节点使用单纯dfs，比较直观。注意这种方法要用一个类属性来记录res
 */
// class Solution {
//     public int pathSum(TreeNode root, int sum) {
//         if (root == null)
//             return 0;
//         return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//     }
    
//     private int dfs(TreeNode root, int sum) {
//         int res = 0;
//         if(root == null)
//             return res;
//         if(root.val == sum)
//             res++;
//         res += dfs(root.left, sum-root.val);
//         res += dfs(root.right, sum-root.val);
//         return res;
//     }
// }

class Solution {
    private int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode curNode = q.poll();
            dfs(curNode, sum);
            
            if(curNode.left != null) q.offer(curNode.left);
            if(curNode.right != null) q.offer(curNode.right);
        }
        
        return res;
    }
    
    private void dfs(TreeNode node, int sum) {
        if(node == null) return;
        
        if(sum == node.val) res++;
        
        dfs(node.left, sum-node.val);
        dfs(node.right, sum-node.val);
    }
}
