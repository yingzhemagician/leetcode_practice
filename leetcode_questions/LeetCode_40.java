/*
Combination 2
与1的区别是，数组中有重复元素，每个元素只能用一次，但是结果不能有重复

基本思路跟1一样，但是在dfs的for循环里，要判断i和i-1是不是一样，一样的话就跳过，但是当i时当前层第一次循环时，因为此时i-1应该是上一层用的，所以不用跳过这个i，所以判断是要排除i是curIdx的情况

循环中，如果当前元素已经比tempTarget小于或等于，就尝试dfs
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, tempList, res, 0);
        
        return res;
    }
    
    private void dfs(int[] candidates, int target, List<Integer> tempList, List<List<Integer>> res, int curIdx){
        if(target < 0)
            return;
        if(target == 0){
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = curIdx; i < candidates.length; i++){
            if(i != curIdx && candidates[i] == candidates[i-1])
                continue;
            if(candidates[i] <= target){
                tempList.add(candidates[i]);
                dfs(candidates, target-candidates[i], tempList, res, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
