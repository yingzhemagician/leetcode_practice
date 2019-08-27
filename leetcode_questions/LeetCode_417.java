/*
挺好的题，就是分别从上边&左边，右边&下边分别用大西洋和太平洋BFS遍历一遍，没用队列

然后能遍历到的点，都写成true写在两个boolean的标记矩阵里

最后遍历两个boolean矩阵，都是true的就输出坐标到res
*/

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        
        boolean pVisited[][] = new boolean[matrix.length][matrix[0].length];
        boolean aVisited[][] = new boolean[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++){
            bfsFlowTo(pVisited, matrix, i, 0);
            bfsFlowTo(aVisited, matrix, i, matrix[0].length-1);
        }
        
        for(int j = 0; j < matrix[0].length; j++){
            bfsFlowTo(pVisited, matrix, 0, j);
            bfsFlowTo(aVisited, matrix, matrix.length-1, j);
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j <matrix[0].length; j++){
                if(pVisited[i][j] && aVisited[i][j])
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return res;
    }
    
    private void bfsFlowTo(boolean visited[][], int[][] matrix, int i, int j){
        visited[i][j] = true;
        
        for(int k = 0; k < 4; k++){
            int new_i = i+dx[k];
            int new_j = j+dy[k];
            
            if(new_i >= 0 && new_i < matrix.length && new_j >= 0 && new_j < matrix[0].length)
                if(visited[new_i][new_j] == false && matrix[new_i][new_j] >= matrix[i][j])
                    bfsFlowTo(visited, matrix, new_i, new_j);
        }
    }
}
