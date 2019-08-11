class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> stack = new LinkedList<String>();
        
        for(String s:path.split("/")){
            if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.removeLast();
            }
            else if(!s.equals("") && !s.equals("."))
                stack.add(s);
        }
        
        for(String s:stack)
            sb.append(s + "/");
        
        if(!stack.isEmpty())
            sb.setLength(sb.length() - 1);
        
        return sb.toString();
    }
}