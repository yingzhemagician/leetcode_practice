/*
用栈匹配，不是一对儿就push，是一对儿就pop，最后看栈是否非空，可以剪枝，但是代码略麻烦
*/
class Solution {
    public boolean isValid(String s) {
        boolean isValid = false;
        
        Stack<Character> stack = new Stack<Character>();
        // char[] charArray = s.toCharArray();
        
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!stack.empty()){
                char top = stack.peek();
                
                if((top == '(' && c == ')') || 
                   (top == '[' && c == ']') || 
                   (top == '{' && c == '}'))
                    stack.pop();
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }
        
        if(stack.empty())
            isValid = true;
        
        return isValid;
    }
}
