/*
方法一；双端队列（其实用StringBuilder直接实现就行），每读一个字符就把它和deque中的最后一个做比较，一样就弹出最后一个，不一样就把新的放进去
最后队列转成sb转成String
*/

// class Solution {
//     public String removeDuplicates(String S) {
//         StringBuilder sb = new StringBuilder();
        
//         for (char c : S.toCharArray()) {
//             int size = sb.length();
//             if (size > 0 && sb.charAt(size - 1) == c)
//                 sb.deleteCharAt(size - 1); 
//             else
//                 sb.append(c);  
//         }
//         return sb.toString();
//     }
// }

/*
方法二：双指针，就是操作起来不一样，其实整体思路一样。一个指针负责写的位置，一个指针负责查的位置
*/
class Solution {
    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        int pos = -1;
        for (char c : arr) {
            if (pos >= 0 && arr[pos] == c)
                pos--; 
            else { 
                pos++;
                arr[pos] = c; 
            }
        }
        return String.valueOf(arr, 0, pos+1);
    }
}


