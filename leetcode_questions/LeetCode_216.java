/*
和1，2区别不大
就是输入是1到9，每个数用一次，只能用k个数

就是多几个判断
*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        
        dfs(k, n, 1, tempList, res);
        return res;
    }
    
    private void dfs(int k, int n, int curNum, List<Integer> tempList, List<List<Integer>> res){
        if(k <= 0){
            if(k == 0){
                if(n == 0)
                    res.add(new ArrayList(tempList));
            }
            return;
        }
        
        for(int i = curNum; i <= 9; i++){
            if(curNum > n)
                break;
            
            tempList.add(i);
            dfs(k-1, n-i, i+1, tempList, res);
            tempList.remove(tempList.size()-1);
        }
    }
}
