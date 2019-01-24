class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, column = obstacleGrid[0].length;
        if(row == 0 || column == 0 || obstacleGrid[0][0] == 1) return 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                
                if(obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else if(i == 0 && j == 0) obstacleGrid[i][j] = 1;
                else if(i == 0 && j != 0) obstacleGrid[i][j] = obstacleGrid[i][j-1];
                else if(i != 0 && j == 0) obstacleGrid[i][j] = obstacleGrid[i-1][j];
                else
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[row-1][column-1];
    }
}