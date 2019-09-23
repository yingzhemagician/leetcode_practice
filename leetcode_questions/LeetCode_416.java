/*
DFS 思路会超时，DFS思路和combination sum一样

复习01背包问题
思路还是算出sum的一般，作为target，然后设一个一维DP数组，每个dp[i]表示和为i能不能做到
因此dp长度是target+1，因为首个索引是0，最后一个是target，总共是target+1

dp[0]是true
遍历是先遍历nums中的每个num
    对于每个num，遍历一遍dp，从后往前，也就是从target开始，每次减一，知道i减小到num
        相当于用dp[i-num]去预测dp[i]，因为会遍历dp很多次，所以每次dp[i]本身可能已经是true了
        因此dp[i] = dp[i] || dp[i-num]
        不能从前往后遍历！如果这样的话，第一个数是1，就所有都是true了

*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        
        if((sum & 1) == 1) return false;
        int target = sum >> 1;
        
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        
        for(int num : nums)
            for(int i = target; i >= num; i--)
                dp[i] = dp[i] || dp[i-num];

                

        return dp[target];
    }
}

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for (int num: nums)
//         	sum += num;

//         if((sum & 1) == 1) return false;
//         int target = sum >> 1;
//         return dfs(nums, target, 0);
//     }

//     public boolean dfs(int[] nums, int target, int startIndex) {
//     	if (target == 0) return true;
//     	if (target > 0) {
// 	    	for (int i = startIndex; i < nums.length; i++) {
// 	    		if (target - nums[i] < 0)
//                     break;
// 	    		if (dfs(nums, target-nums[i], i+1)) {
// 	    			return true;
// 	    		}
	    		
// 	    	}
// 	    }
//     	return false;
//     }
// }
