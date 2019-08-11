class Solution {
    public int[][] generateMatrix(int n) {
        int max = n * n;
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1, up = 0, down = n-1;
        int i = up, j = left, x = 1;
        
        while(x <= max){
            //to right
            while(j <= right){
                matrix[i][j] = x;
                x++;
                j++;
            }
            up++;
            j--;
            i = up;
            
            //down
            while(i <= down){
                matrix[i][j] = x;
                x++;
                i++;
            }
            right--;
            i--;
            j = right;
            
            //left
            while(j >= left){
                matrix[i][j] = x;
                x++;
                j--;
            }
            down--;
            j++;
            i = down;
            
            //up
            while(i >= up){
                matrix[i][j] = x;
                x++;
                i--;
            }
            left++;
            i++;
            j = left;
        }
        return matrix;
    }
}