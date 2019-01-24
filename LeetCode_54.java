class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        if(row == 0)
            return res;
        if(row == 1){
            for(int x : matrix[0])
                res.add(x);
            return res;
        }
        int column = matrix[0].length, num = 1; 
        if(column == 1){
            for(int i = 0; i <= row - 1; i++){
                res.add(matrix[i][0]);
            }
            return res;
        }
        int up = 0, down = row - 1, left = 0, right = column - 1;
        int i = 0, j = 0;
        int max = row * column;
        
        while(num <= max){
            //right
            while(j <= right && num <= max){
                res.add(matrix[i][j]);
                num++;
                j++;
            }
            
            j--;
            up++;
            i = up;
            
            //down
            while(i <= down && num <= max){
                res.add(matrix[i][j]);
                num++;
                i++;
            }
            
            i--;
            right--;
            j = right;
            
            //left
            while(j >= left && num <= max){
                res.add(matrix[i][j]);
                num++;
                j--;
            }
            
            j++;
            down--;
            i = down;
            
            //up
            while(i >= up && num <= max){
                res.add(matrix[i][j]);
                num++;
                i--;
            }
            
            i++;
            left++;
            j = left;
        }
        
        return res;
    }
}