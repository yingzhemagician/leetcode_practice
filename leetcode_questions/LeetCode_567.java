/*
用滑动窗口思想，窗口长度就是s1的长度，注意考虑到两个都是空串或者s1比s2长的Corner case

s1短，s2长
思路是用映射统计字串中的字符个数，实现的时候直接用一个数组就行
因为只有26个小写字符，所以int[26]

在s2上滑动时，每遇到一个char就在int[26]的相应位置--，每离开一个字符就相应位置++
滑动起始应该是
e i d b a o o o
[  ]
因此要先把s2前面len1个比对一下，然后滑动开始
int[]里面都是0的时候就返回true，谁也不欠谁
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
         
        int[] count = new int[26];
        
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
         
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }
        return false;
    }
    
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
