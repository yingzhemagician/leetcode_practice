//recursive
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        
        generate(n, n, "", res);
        
        return res;
    }
    
    public void generate(int left, int right, String temp, List<String> res){
        if(left == 0 && right == 0){
            res.add(temp);
            return;
        }
        
        if(left < 0 || right < 0 || left > right) return;
        
        generate(left-1, right, temp+"(", res);
        generate(left, right-1, temp+")", res);
    }
}