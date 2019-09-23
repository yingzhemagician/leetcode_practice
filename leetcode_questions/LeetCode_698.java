/*
和combination sum差不多，只是用used记录哪个数用过了，用过的就不要再用了
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        
        if(sum % k != 0)
            return false;
        
        int target = sum / k;
        
        return dfs(nums, k, target, 0, 0, 0, new boolean[nums.length]);
    }
    
    private boolean dfs(int[] nums, int k, int target, int start, int curSum, int matchCount, boolean[] used){
        if(curSum > target)
            return false;
        if(target == curSum){
            matchCount++;
            if(matchCount == k)
                return true;
            return dfs(nums, k, target, 0, 0, matchCount, used);
        }
        
        for(int i = start; i < nums.length; i++){
            if(used[i])
                continue;
            
            used[i] = true;
            
            if(dfs(nums, k, target, i, curSum + nums[i], matchCount, used))
                return true;
            
            used[i] = false;
        }
        
        return false;
    }
}
