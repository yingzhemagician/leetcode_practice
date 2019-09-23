/*
相当于只遍历第一个字串中的每个字符，然后针对它每个字符，再遍历字符串数组中其他字串，看i是否超过了其他任一串的长度或者这个位置的字符已经不一样了
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";  
        
        for (int i = 0; i < strs[0].length(); i++)  
            for (String each_str : strs)  
                if (i == each_str.length() || each_str.charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);  
        
        return strs[0]; 
    }
}
