/*
其实还是三个指针
cur是指向位置是已经被修改好的最后一个位置（最终返回cur，也就是新字串长度，cur指向的是新字符串的后一个字符）
i遍历原字符串，一点点往后走
j是 从i往后走，直到 扫到与 i指向 不同的那个元素 之前

i从0开始遍历，每次j先赋值为i，然后j往后走，判断条件是j只能走到导数第二个位置，且后一个要等于前一个
因此j最终走到了最后一个相同点
此时先把cur的位置赋值成i指向的字符，然后cur后移

如果此时i j相等，说明j没走，i变成j+1
如果不相等，那么先看重复次数，并转成字符串，算出这个“次数”的字符串长度
然后把“次数”写在cur那里，再后移cur，最后i变成j+1

*/

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int cur = 0;
        
        for(int i = 0; i < n; ) {
            int j = i;
            while(j < n - 1 && chars[j] == chars[j+1])
                j++;
            chars[cur++] = chars[i];
            
            if(i != j) {
                String times = (j - i + 1) + "";
                int tLen = times.length();
                
                for(int k = 0; k < tLen; k++)
                    chars[cur++] = times.charAt(k);
            }
            i = j + 1;
        }
        return cur;
    }
}


