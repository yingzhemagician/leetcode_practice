/*
字符串处理
先判断n是否小于0或者等于1

然后整体思路就是，做一个n-1次的循环，每次循环都将字符串s1编变成s2（所以是n-1次）
因此在进入循环前建立s1和s2字串，每一次循环，都用s1建立s2，然后s2就是下一次的s1
    
最后返回s1.toString()
*/

class Solution {
    public String countAndSay(int n) {
        
        if(n <= 0) return "";
        if(n == 1) return "1";
        
        StringBuilder s1 = new StringBuilder("1");
        StringBuilder s2 = new StringBuilder("");
        
        //1到n-1，n-1次的结果就是第n号count and say
        for(int i = 1; i < n; i++){
            //获取第一个字符，并初始化它的次数
            char curChar = s1.charAt(0);
            int count = 1;
            
            //从第二个字符开始遍历字符串，若后面字符和当前字符相等，就count++；否则将count和curChar放进s2
            //并更新count和curChar
            for(int j = 1; j < s1.length(); j++){
                if(s1.charAt(j) == curChar)
                    count++;
                else{
                    s2.append(count);
                    s2.append(curChar);
                    
                    count = 1;
                    curChar = s1.charAt(j);
                }  
            }
            
            //将上面最后一次循环的结果放进s2
            s2.append(count);
            s2.append(curChar);
            
            //s2赋值给s1
            s1.delete(0, s1.length());
            s1.append(s2);
            s2.delete(0, s2.length());   
        }
        return s1.toString();
    }
}
