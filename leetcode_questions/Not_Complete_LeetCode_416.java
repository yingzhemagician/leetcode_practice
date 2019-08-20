// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int num : nums){
//             sum += num;
//         }
//         int target = sum >> 1;
//         if((sum & 1) == 1) return false;
        
//         boolean[] dp = new boolean[target+1];
//         dp[0] = true;
        
//         for(int num : nums){
//             for(int i = target; i >= num; i--){
//                 dp[i] = dp[i] || dp[i-num];
//             }
//         }
//         return dp[target];
//     }
// }

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums)
        	sum += num;

        if(sum % 2 != 0) return false;
        
        return dfs(nums, sum/2, 0, nums.length-1);
    }

    public boolean dfs(int[] nums, int target, int curSum, int startIndex) {
    	if (curSum == target) return true;
    	if (curSum < target) {
            
	    	for (int i = startIndex; i >= 0; i--) {
	    		if (curSum + nums[i] > target)
                    break;
	    		if(dfs(nums, target, curSum+nums[i], i-1)) {
	    			return true;
	    		}
	    		
	    	}
	    }
    	return false;
    }
}
