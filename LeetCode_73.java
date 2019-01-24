class Solution {
    public void setZeroes(int[][] matrix) {
        int zeroRow = 1, zeroColumn = 1;
        int row = matrix.length, column = matrix[0].length;
        if(row == 0 || column == 0) return;
        
        for(int j = 0; j < column; j++)
            if(matrix[0][j] == 0){
                zeroRow = 0;
                break;
            }
        
        for(int i = 0; i < row; i++)
            if(matrix[i][0] == 0){
                zeroColumn = 0;
                break;
            }
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < column; j++)
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
        }
        
        for(int j = 1; j < column; j++)
            if(matrix[0][j] == 0)
                for(int i = 0; i < row; i++)
                    matrix[i][j] = 0;
        
        for(int i = 1; i < row; i++)
            if(matrix[i][0] == 0)
                for(int j = 0; j < column; j++)
                    matrix[i][j] = 0;
        
        if(zeroRow == 0)
            for(int j = 0; j < column; j++)
                matrix[0][j] = 0;
        
        if(zeroColumn == 0)
            for(int i = 0; i < row; i++)
                matrix[i][0] = 0;     
    }
}