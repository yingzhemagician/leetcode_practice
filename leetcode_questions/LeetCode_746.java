/*
跟爬梯子完全一样，就是dp这次表示花费
法一用数组
法二只用三个变量
*/

// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int[] dp = new int[cost.length + 1];
//         dp[0] = 0;
//         dp[1] = 0;
        
//         for (int i = 2; i < dp.length; i++)
//             dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);

//         return dp[dp.length - 1];
//     }
// }

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i < length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2] , dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }
}
