/*
常规DP，就是斐波那契额数列
就是设一个n+1的dp[]数组，dp[1]=1就是爬1层有一种方法，dp[2]=2就是爬2层有两种方法

然后从i=3开始遍历到n
    dp[i]=dp[i-1]+dp[i-2]
    
最后返回dp[n]
*/

// public class Solution {
//     public int climbStairs(int n) {
//         if (n <= 1)
//             return 1;
//         int[] dp = new int[n+1];
//         dp[1] = 1;
//         dp[2] = 2;
        
//         for (int i = 3; i <= n; i++)
//             dp[i] = dp[i - 1] + dp[i - 2];

//         return dp[n];
//     }
// }

public class Solution {
    public int climbStairs(int n) {
        if (n <= 3)
            return n;
        
        int num1 = 2, num2 = 3, sum = 0;
        
        for (int i = 4; i <= n; i++){
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
            
        }
        return sum;
    }
}
