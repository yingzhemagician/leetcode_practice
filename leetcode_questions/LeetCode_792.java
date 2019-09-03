/*
这个思路挺简单的
两个set，一个记录“是子序列的word”，另一个记录“不是子序列的word”

遍历words，如果sub包含了，就res++，如果nonSub包含了就直接continue，如果都不包含，就判断是不是子序列
    是的话，sub.add，res++
    不是的话，nonsub.add
    
判断是不是
遍历这个word中的每个字符
    看当前字符在字符串的index+1以后是否存在，index其实就表示当前字符的上个字符在串中的位置
    index的初始值是-1，所以第一个c的遍历是从串的0开始
    如果找到当前c，就把index赋值为它的位置，如果没找到，就return false
都遍历完了，return true
*/

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        HashSet<String> sub = new HashSet<>();
        HashSet<String> nonsub = new HashSet<>();
        int res = 0;
        
        for(String word:words){
            if(sub.contains(word)){
                res++;
                continue;
            }
            else if(nonsub.contains(word)){
                continue;
            }
            else{
                if(isSub(S, word)){
                    sub.add(word);
                    res++;
                }
                else
                    nonsub.add(word);
            }
        }
        return res;
    }
    
    public static boolean isSub(String S, String word){
        int index = -1;
        for(char c: word.toCharArray()){
            index = S.indexOf(c, index+1);
            if (index == -1)
                return false;
        }
        return true;
    }
}
