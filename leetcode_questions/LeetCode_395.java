/*
每个字符至少出现k次的最长子串，可以反复看
递归
每次先统计当前子串中，字符出现的频率，用count[26]

然后建立一个allValid标记这个完整的子串是不是合法的，valid[26]记录每个字符是不是合法
遍历count[]，判断count[i]频率是不是在(0, k)之间，在就不合法，valid有一个不合法，allValid就不合法

如果allValid合法就直接返回子串长度，否则进入分治

从头遍历子串每个字符，如果这个字符对应的valid[]不合法，就对[start, i)调用递归
记录递归返回值max，下次递归的start从i+1开始，因为上次已经找到了start到i之间的合法串最大值

遍历完所有字符后，还要算一下从当前start到最后一个字符这个串的max，因为在for循环中，这个串没被包含
*/

public class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(n < k) return 0;
        
        int count[] = new int[26];
        for(int i = 0; i < n; i++) 
            count[s.charAt(i)-'a']++;
        
        //检查当前字符串是否是完全满足的
        boolean allValid = true;
        boolean valid[] = new boolean[26];
        //判断每个字符的出现条件是否合适，即，要么不出现，要么出现了不少于k
        for(int i = 0; i < 26; i++){
            if(count[i] > 0 && count[i] < k){
                valid[i] = false;
                allValid = false;
            }
            else
                valid[i] = true;
        }
        
        if(allValid)
            return s.length();
        
        int max = 0;
        int start = 0;
        
        //把不符合要求的断开，然后依次检查 取最大
        for(int i = 0; i < n; i++){
            if(valid[s.charAt(i)-'a'] == false){
                max = Math.max(max, longestSubstring(s.substring(start, i), k));
                start = i+1;
            }
        }
        max = Math.max(max,longestSubstring(s.substring(start, n),k));
        return max;
    }
}
