/*
很简单
建立两个hashmap，A记录 <字符，对应的单词>，B记录 <单词，对应的字符>
这样的设计是为了在遍历字符串pattern时，如果 字符已经有过对应的单词，就去比单词，如果没对应过，那么检查该单词有没有对应的字符，都没有，才往两个map里放
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        int pattnLen = pattern.length();
        String[] words = str.split(" ");
        int wordsLen = words.length;
        
        if(pattnLen != wordsLen || pattnLen == 0 || wordsLen == 0)
            return false;
        
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();
        
        for(int i = 0; i < pattnLen; i++){
            if(charToStr.containsKey(pattern.charAt(i))){
                if(!charToStr.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            }
            else{
                if(strToChar.containsKey(words[i]))
                    return false;
                else{
                    charToStr.put(pattern.charAt(i), words[i]);
                    strToChar.put(words[i], pattern.charAt(i));
                }
            }
        }
        return true;
    }
}
