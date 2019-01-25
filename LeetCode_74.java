class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0 ) return false;
        int column = matrix[0].length;
        if(column == 0) return false;
        
        int left = 0, right = row * column - 1;
        int mid = 0, mid_i = 0, mid_j = 0;
        int left_i = 0, left_j = 0, right_i = 0, right_j = 0;
        
        while(left <= right){
            mid = left + (right - left)/2;
            
            mid_i = mid / column; 
            mid_j = mid % column;
            
            left_i = left / column;
            left_j = left % column;
            
            right_i = right / column;
            right_j = right % column;
            
            if(matrix[mid_i][mid_j] == target) return true;
            
            if(matrix[left_i][left_j] <= target && target < matrix[mid_i][mid_j])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}