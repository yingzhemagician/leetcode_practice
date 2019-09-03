/*
因为两端的数平方比较大，所以双指针，大的数算出平方放在res的后面
很简单
*/
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        
        int left = 0, right = A.length-1, idx = res.length-1;
        
        while(left <= right){
            if(Math.abs(A[left]) < Math.abs(A[right])){
                res[idx] = A[right]*A[right];
                right--;
            }
            else{
                res[idx] = A[left]*A[left];
                left++;
            }
            idx--;
        }
        
        return res;
    }
}
