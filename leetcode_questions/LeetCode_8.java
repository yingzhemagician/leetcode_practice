/*
首先判断输入的str是不是空，然后初始化sign为1，base为0
然后用i和while来遍历字符串前面的空格

直到第一个字符不在是空
然后判断这个字符是不是加号或者减号，加号的话sign就是1，减号的话就是-1

然后继续用i遍历剩下的字符
while只要i小于len且该字符在'0'到'9'之间
    判断此时base是不是已经大于 int最大值/10，或者是不是已经等于int最大值/10且字符比7大
        如果是的话说明已经越界，那么根据sign返回最大或者最小边界就行
    如果不越界的话，那么就是base*10+当前字符对应的数字就行

最后返回base*sign
*/
class Solution {
    public int myAtoi(String str) {
        if(str.isEmpty()) return 0;
        
        int sign = 1, base = 0, i = 0, len = str.length();
        
        while(i < len && str.charAt(i) == ' ') i++;
        
        if(i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) 
            sign = (str.charAt(i++) == '+')? 1 : -1;
        
        while(i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            if(base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && str.charAt(i)-'0' > 7))
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            base = 10 * base + (str.charAt(i) - '0');
            i++;  
        }
        return base * sign;
    }
}
