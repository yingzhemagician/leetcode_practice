/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 经典DFS
 DFS的参数是当前节点，到达当前节点前的和，想要的和，当前节点前的路径，res集合
 先算出到达此节点的curSum，再把当前节点值加在temp路径里
 如果当前节点是叶子，就判断curSum和sum是不是相等，相等了，就把temp加到res里
                                            不相等就跳过
 最后删掉tempPath中的这个点返回（删掉当前节点是因为tempPath是list传的是引用）

 如果不是叶子节点，就判断左右是否非空然后再去DFS
 最后temp里删掉当前点
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null) return res;
        
        List<Integer> tempPath = new ArrayList<Integer>();
        
        DFS(root, 0, sum, tempPath, res);
        
        return res;
    }
    
    public void DFS(TreeNode node, int preSum, int sum, List<Integer> tempPath, List<List<Integer>> res){
        int curSum = preSum + node.val;
        tempPath.add(node.val);
        
        if(node.left == null && node.right == null){
            if(curSum == sum)
                res.add(new ArrayList(tempPath));
            tempPath.remove(tempPath.size()-1);
            return;
        }
        
        if(node.left != null)
            DFS(node.left, curSum, sum, tempPath, res);
        
        if(node.right != null)
            DFS(node.right, curSum, sum, tempPath, res);
        
        tempPath.remove(tempPath.size()-1);
    }
}
