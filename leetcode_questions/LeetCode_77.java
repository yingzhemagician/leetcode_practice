/*
经典回溯，就是遍历数组，要知道当前层从哪个索引开始遍历
第一层从1开始                     [1,2,3,4,5]
对于第一层的1，第二层从2开始        1->[2,3,4,5]
每一层中，用for循环实现对接下来的每个元素进行DFS

注意这里有个地方可以剪枝，就是当需要k个数，但是start到n已经不足k个数了，就没必要对剩下的DFS了
如果把这个点结合到for的判断里就更好了

迭代解法是
[0, 0, 0]先递增右边的数字，不能递增之后再递增倒数第二个数字。。。
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(n < k) return res;
        
        helper(1, n, k, temp, res);
        
        return res;
    }
    
    private void helper(int start, int n, int k, List<Integer> temp, List<List<Integer>> res){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        //剪枝，并不是最完美的剪枝
        if(k-temp.size() > n-start+1)
            return;

        for(int i = start; i <= n; i++){
            temp.add(i);
            helper(i+1, n, k, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
