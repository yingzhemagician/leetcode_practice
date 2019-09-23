/*
中心扩散法，比DP好理解
全局变量left记录结果的左端起始位置，max记录结果的长度

遍历字符串s，每遇到一个字符，就以该字符的index为中点（回文串abb c bba类型）
                        或者该字符和下一个字符为中点（回文串abb cc bba类型）去检测
                        
check() 方法里，while实现左右的扩散直到不能扩散
然后左右回到上一个位置

判断当前左右长度和max的关系并重新复制max和left

如果check进来的时候不是回文或者right到达边界，那么left++和right--之后，right-left+1就是0，不会更新max和left

*/

class Solution {
    int start, max = 0;
    
    public String longestPalindrome(String s) {
        
        for(int i = 0; i < s.length(); i++){
            check(s,i,i);
            check(s,i,i+1);
        }
        return s.substring(start, start+max);
    }
    
    public void check(String s, int left,int right){

        //向外扩散
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        //while结束时，left和right不是正确的位置，都要往回走一个
        left++;
        right--;
        
        if(max < (right-left+1)){
            max = right - left + 1;
            start = left;
        }
    }
}



/*
思路是DP，但是效率低
初始化全0的DP数组，然后初始化左边界left和右边界right，len为0

遍历字符串 i从0到末尾
    对于每个i，内层循环j遍历从0到i-1，每次循环是为了计算dp[j][i]
    如果i和j指向的字符相等，那么判断
        如果j到i的距离小于2，也就是说j和i是挨着的 或者 j+1到i-1 是回文
        那么这种情况下，j到i是回文
        
    如果不相等的话dp[j][i]还是0
    如果j到i是回文了且j到i的距离大于记录的len，则更新len，left和right
    
    循环最后别忘了dp[i][i]设为1
*/

// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length() == 0) return "";
        
//         int dp[][] = new int[s.length()][s.length()];
//         int left = 0, right = 0, len = 0;
        
//         for(int i = 0; i < s.length(); i++){
//             for(int j = 0; j < i; j++){
//                 if(s.charAt(i) == s.charAt(j))
//                     if(i-j < 2 || dp[j+1][i-1] == 1)
//                         dp[j][i] = 1;

//                 if(dp[j][i] == 1 && len < i-j+1){
//                     len = i-j+1;
//                     left = j;
//                     right = i;
//                 }
//             }
//             dp[i][i] = 1;
//         }
//         return s.substring(left, right+1);
//     }
// }
