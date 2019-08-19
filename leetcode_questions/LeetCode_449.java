/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 序列化就是用先序遍历，根左右，遇到null的时候用#记录，每添加一个元素到sb里面都顺便加一个“,”
 反序列化先把data字符串split(",")，然后addAll()到一个queue里面
 每次poll()一个出来，这个元素要是#就直接返回null，否则新建节点，将str换成Integer，然后在递归左右节点
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    
    private void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#").append(",");
            return;
        }
        
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserial(queue);
    }
    
    private TreeNode deserial(Queue<String> queue){
        String str = queue.poll();
        if(str.equals("#"))
            return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = deserial(queue);
        node.right = deserial(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
