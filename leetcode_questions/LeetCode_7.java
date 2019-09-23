/*
就是一位位取，然后res*10+digit
整数范围-2147483648 ~ 2147483647
所以digit就是用取余去最后的数字，然后加到res*10的后面，然后x相应就要除以10
但是为了保证res*10+digit这个操作不越界，首先保证res*10
    对于正数，res*10不能超过Integer.MAX_VALUE，也就是res > Integer.MAX_VALUE/10。而且，当res*10之后正好是正数最大值减7，则新的digit必须小于等于7
    负数同理
*/
class Solution {
    public int reverse(int x) {
        int res = 0;
        
        while(x != 0){
            int digit = x % 10;
            
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && digit > 7))
               return 0;
            if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && digit < -8))
               return 0;
            
            res = res * 10 + digit;
            x /= 10;
        }
        return res;
    }
}
