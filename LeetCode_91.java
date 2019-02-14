class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        
        int[] dp = new int[s.length()+1];
        
        dp[0] = 1;
        dp[1] = 1;
        int tempNum = 0;
        
        for(int i = 2; i < dp.length; i++){
            if(s.charAt(i-1) == '0') dp[i] = 0;
            else dp[i] = dp[i-1];
            
            tempNum = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
            if(tempNum >= 10 && tempNum <= 26)
                dp[i] += dp[i-2];
        }
        return dp[dp.length-1];  
    }
}