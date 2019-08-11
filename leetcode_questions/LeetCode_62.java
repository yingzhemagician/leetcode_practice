class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];
        
        for(int i = 0; i < n; i++)
            Arrays.fill(matrix[i], 1);
        
        for(int i = 1; i < n; i++)
            for(int j = 1; j< m; j++)
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
        
        return matrix[n-1][m-1];
    }
}