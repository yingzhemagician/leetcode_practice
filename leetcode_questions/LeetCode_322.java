/*
DP 有点意思
思路是，从amount=0开始算起，看总钱数是i是最少需要多少个硬币，直到i=amount

dp数组长为amount+1，里面代表0到amount
dp[0]就是0，0元不需要任何硬币
然后其他的元素初始化为amount+1，因为如果有1元硬币，那么amount最大需要amount个硬币，所以最大值是amount+1

然后每次计算一个dp[i]元素，都要在之前某个dp[]的基础上加上硬币数组中一个硬币值，也就是要遍历一遍硬币，只遍历小于当前i的硬币就行

转移方程是 min(dp[i], dp[i - coins[j]] + 1)，也就是遍历硬币时，先用当前值减去硬币面值得到x，看dp[x]是多少，然后dp[x]+1就是dp[i]的“候选值”

最后判断最后一个值是不是比amount大就行
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        
        for(int i = 1; i < dp.length; i++)
            for(int j = 0; j < coins.length; j++)
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
