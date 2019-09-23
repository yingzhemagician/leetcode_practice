/*
两种思路
第一种就是一层一层使用二分法，每层都重新搜索

第二种就是 从右上角开始，如果比它小，那么就col--，如果比它大，就row++
因为这个矩阵中，右边一定比左边大，下边一定比上边大，所以从右上角开始
    如果target比较小的话，那么当前列就不用看了
    如果target比较大的话，那么当前行就不用看了

*/

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if(matrix == null) return false;
//         if(matrix.length == 0 || matrix[0].length == 0) return false;
   
//         for(int row = 0; row < matrix.length; row++){
//             int left = 0, right = matrix[0].length-1, mid = 0;
            
//             while(left <= right){
//                 mid = left+(right-left)/2;
            
//                 if(matrix[row][mid] == target) return true;
//                 else if(target < matrix[row][mid]){
//                     right = mid-1;
//                 }
//                 else{
//                     left = mid+1;
//                 }
//             }
//         }
//         return false;
//     }
// }


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;

		int row = 0;
		int col = matrix[row].length-1;

		while(row < matrix.length && col >= 0){

			if(matrix[row][col] < target) row++;
			else if(matrix[row][col] > target) col--;
		    else return true;
		}
		return false;
    }
}
