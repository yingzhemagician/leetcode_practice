/*
方法一：
纯递归，但是这种方法有很多重复计算，比如[1,2,3,4]，递归树是
        1
     2     2
   3   3  3   3
 4  4 4 4 4 4 4 4
 因此，3+4 与 3-4就计算了很多次，还有可能不同路径到达同一层时 和是相等的
 
 方法二：
 
*/

// class Solution {
//     public int findTargetSumWays(int[] nums, int S) {
//         if(nums == null) return 0;
        
//         int res[] = new int[1];
//         helper(nums, 0, S, res);
//         return res[0];
//     }
    
//     private void helper(int[] nums, int curIndex, int sum, int[] res){
//         if(curIndex == nums.length){
//             if(sum == 0){
//                 res[0]++; 
//             }
//             return;
//         }
        
//         helper(nums, curIndex+1, sum - nums[curIndex], res);
//         helper(nums, curIndex+1, sum + nums[curIndex], res);
//     }
// }


class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length, sum = 0;
        
        for(int i : nums)
            sum += i;
        
        if(sum < Math.abs(S) || (sum+S)%2 != 0)
            return 0;
        
        int[] dp = new int[(sum+S)/2+1];   //已知sum+S是偶數, 可找到
        dp[0] = 1;
        
        for(int i : nums)
            for(int j=(sum+S)/2; j>=i; j--)
                dp[j] += dp[j-i]; 

        return dp[(sum+S)/2];
    }
}
