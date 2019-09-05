/*
用一个栈，先把第一个数放进栈，然后之后遍历字符串，每遇到一个操作符，都先读取一下它后面的数
然后判断这个操作符是什么，
    + ：直接把num2入栈（最后弹出所有的数相加就是结果）
    - ：num变负再入栈
    * ：弹出栈顶为num1，计算num1*num2，再push
    / ：同上，计算结果push进栈

最后求栈里面的和
*/

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        s = s.replaceAll(" ", "");
        
        int i = 0;
        int num = 0;
        
        while(i < s.length() && Character.isDigit(s.charAt(i)))
            num = num * 10 + s.charAt(i++) - '0';
        
        stack.push(num);
        
        while(i < s.length()){
            char op = s.charAt(i++);
            
            int num2 = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i)))
                num2 = num2 * 10 + s.charAt(i++) - '0';
            
            if(op == '+'){
                stack.push(num2);
            }
            else if(op == '-'){
                stack.push(-num2);
            }
            else if(op == '*'){
                int num1 = stack.pop();
                stack.push(num1 * num2);
            }
            else if(op == '/'){
                int num1 = stack.pop();
                stack.push(num1/num2);
            }
        }
        
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        
        return res;
    }
}
