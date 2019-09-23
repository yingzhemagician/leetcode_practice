/*
第一种方法，先把字符串按照空格分开，分成字符串数组words，然后从后往前遍历words，遍历到整数第二个，在for循环中直接把每个word[i]+空格 加到res后面，于是跳出循环之后还要把words[0]加上

第二种方法
就是从后往前遍历，如果是空格，那么该位置就是end，
                如果不是空格，那么判断它前一位是不是空格，是的话将这部分放到res后面

看代码吧

*/

// class Solution {
//     public String reverseWords(String s) {
//         String res = "";
        
//         String[] words = s.trim().split("\\s+");
        
//         for(int i = words.length - 1; i > 0; i--)
//             res += words[i] + " ";
        
//         return res + words[0];
//     }
// }

class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == ' ')
                end = i;
            else if (i == 0 || s.charAt(i - 1) == ' '){
                if (res.length() != 0)
                    res.append(' ');

                res.append(s.substring(i, end));
            }
        }
        return res.toString();
    }
}
