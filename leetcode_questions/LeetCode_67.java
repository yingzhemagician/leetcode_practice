/*
读代码
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");
        StringBuilder A = new StringBuilder(a);
        StringBuilder B = new StringBuilder(b);
        
        int lenA = A.length();
        int lenB = B.length();
        int maxLen = Math.max(lenA, lenB);
        
        int carry = 0;
        
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++)
                B.insert(0, "0");
        }
        else if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++)
                A.insert(0, "0");
        }
        
        for (int i = maxLen - 1; i >= 0; i--) {
            int tmpSum = (A.charAt(i) - '0') + (B.charAt(i) - '0') + carry;
            
            if (tmpSum == 0) {
                res.append("0");
                carry = 0;
            }
            else if (tmpSum == 1) {
                res.append("1");
                carry = 0;
            }
            else if (tmpSum == 2) {
                res.append("0");
                carry = 1;
            }
            else if (tmpSum == 3) {
                res.append("1");
                carry = 1;
            }
        }
        if (carry == 1)
            res.append("1");
        return res.reverse().toString();
    }
}
