/*
两个栈，一个用来记录遇到的数字（重复次数）
       一个用来记录到达新的"["时，已经读到的字串
       
遍历字符串，每次取出一个字符
1. 是数字，就从当前的i开始往后找直到i不指向数字，算出这个完整的数
2. 是字母，直接往res后面加
3. 是"["，说明新的一层要开始了，存下现在已经记录好的res，放进栈2里，将当前算出的num也入栈1
    然后清空res和num
4. 是"]"，说明要结算了，从栈1里弹出 次数num，从栈2里弹出上一层的结果 temp，把当前的res按次数接在
    temp后面，接好的字串就是当前上层完好的结果

*/

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>(); // 记录'['之前的数字
        Stack<StringBuilder> resStack = new Stack<>(); // 记录'['之前的运算结果
        
        int curNum = 0;
        StringBuilder res = new StringBuilder("");
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                while (Character.isDigit(s.charAt(i)))
                    curNum = 10 * curNum + (s.charAt(i++) - '0');
                i--;
            }
            else if(ch == '[') {
                resStack.push(res);
                res = new StringBuilder("");//注意
                
                countStack.push(curNum);
                curNum = 0;// 注意
            }
            else if(ch == ']') { // 取出计算结果，和数字
                StringBuilder pre = resStack.pop();
                int repeatTimes = countStack.pop();
                
                for (int j = 0; j < repeatTimes; j++)
                    pre.append(res);
                
                res = pre;
                
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
