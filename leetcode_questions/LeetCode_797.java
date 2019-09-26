/*
标准DFS回溯，在图里找所有路径
每次DFS，先把当前走到的curNode加到curPath里，如果curNode是target-1了，那么就加进res然后返回
如果还没到终点，就for遍历所有的邻居（其实是边），然后依次DFS进去
*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, 0, graph.length, graph, new ArrayList<Integer>());
        return res;
    }
    
    void dfs(List<List<Integer>> res, int curNode, int target, int[][] graph, List<Integer> curPath) {
        curPath.add(curNode);
        if (curNode == target-1) {
            res.add(new ArrayList(curPath));
            //res.add(curPath);此处注意，不要直接把curPath这个list放进res里，因为放的是引用
            return;
        }
        
        for (int neighbor : graph[curNode]) {
            dfs(res, neighbor, target, graph, curPath);
            curPath.remove(curPath.size() - 1);
        } 
    }
}
