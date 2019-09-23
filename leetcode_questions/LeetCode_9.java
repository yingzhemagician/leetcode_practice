/*
整体思路就是 掐头去尾
首先很巧妙的是如何去算最高位的位数base

设base=1，用x去除base，如果除完结果大于等于10，说明base没到x的最高位
最终base就是最高位，比如x是1234，m就是1000

然后进入循环，只要x大于0就继续循环
left：用x/base来取
right：用x%10来取

如果不等就退出了，错误

相等的话继续，这时，x需要掐头去尾，先掐头，用x%m得到最高位后面的余数，然后余数除以10，得到掐头去尾
base同时也要缩小，因为掐头去尾了，所以base要缩小100倍
*/
class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0) return false;
        
        int base = 1;
        
        while(x / base >= 10)
            base *= 10;
            
        int left = 0, right = 0;
        
        while(x > 0){
            left = x / base;
            right = x % 10;
            
            if(left != right) return false;
            
            x = (x % base) / 10;
            base = base / 100;
        }
        return true;  
    }
}
