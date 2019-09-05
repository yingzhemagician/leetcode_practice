/*
滑动窗口
left左，i是右，index数组长为256，记录每个字符最新出现的下标，初始化为-1
遍历string
    比较当前字符s.charAt(i)在index里的最新位置和left左边界谁大，大的那个成为新的边界，因为不能有重复
    然后更新index的s.charAt(i)位置
    然后算距离，同时维护一个res，每次算出的距离和res比谁小
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] index = new int[256];
        
        Arrays.fill(index, -1);
        
        int maxLen = 0, left = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            //更新左边界，要么还是原来的左边界，要么是i指向的当前字符在index[]中的最新位置的下一个
            left = Math.max(left, index[curChar]+1);
            index[curChar] = i;
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
