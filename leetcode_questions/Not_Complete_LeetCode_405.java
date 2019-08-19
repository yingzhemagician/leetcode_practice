/*
num & 0xF的作用
*/

class Solution {
    public String toHex(int num) {
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num == 0) return "0";
        
        String result = "";
        
        while(num != 0){
            result = map[(num & 0xF)] + result; 
            num = (num >>> 4);
        }
        
        return result;

    }
}
