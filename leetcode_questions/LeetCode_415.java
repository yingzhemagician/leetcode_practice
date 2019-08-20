/*
p1 p2两个指针分别从后往前遍历两个字符串
算出 n1 n2，然后和carry一起算出当前位置的sum

然后算出新的carry以及当前位的数
sb.append(int)

最后sb.reverse().toString()
*/

class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int p1 = num1.length()-1, p2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
		
        while(p1 >= 0 || p2 >= 0 || carry == 1){
            int n1 = p1 < 0 ? 0 : num1.charAt(p1)-'0';
            int n2 = p2 < 0 ? 0 : num2.charAt(p2)-'0';
            sb.append((n1+n2+carry)%10);
            carry = (n1+n2+carry)/10;
            p1--;
            p2--;
        }
        return sb.reverse().toString();
    }
}
