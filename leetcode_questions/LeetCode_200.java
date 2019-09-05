/*
标准DFS

首先判断矩阵有效性
然后用res记录岛屿个数

然后一个个遍历矩阵中的元素
    如果元素是1
    那么首先res++，然后进行DFS，DFS参数为（矩阵，当前的i和j，行数和列数）
最终返回res

在DFS的方法中，首先判断当前的i和j是否有效，无效就return，然后判断当前元素是否是1，不是就return

然后把当前的元素改成0
然后dfs去遍历上下左右

BFS也差不多
遍历矩阵中每个1，然后进入BFS，BFS用非递归形式，先构造队列，然后把第一个坐标当前坐标放进去
然后进入while
每次弹出一个坐标，然后看左边的上下左右有没有1，把是1的坐标放进队列，然后该坐标的元素赋值为0
*/

// class Solution {
//     public int numIslands(char[][] grid) {
// 		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
// 		int rows = grid.length;
// 		int cols = grid[0].length;
// 		int res = 0;
        
// 		for (int i = 0; i < rows; i++)
// 			for (int j = 0; j < cols; j++)
// 				if (grid[i][j] == '1') {
// 					res++;
// 					dfs(grid, i, j, rows, cols);
// 				}
// 		return res;
// 	}
 
// 	// 每遇到'1'后, 开始向四个方向 递归搜索. 搜到后变为'0',
// 	// 因为相邻的属于一个island. 然后开始继续找下一个'1'.
// 	private void dfs(char[][] grid, int i, int j, int rows, int cols) {
// 		if (i < 0 || i >= rows || j < 0 || j >= cols) return;
// 		if (grid[i][j] != '1') return;
		
// 		grid[i][j] = '0';
//         dfs(grid, i-1, j, rows, cols);
// 		dfs(grid, i+1, j, rows, cols);
// 		dfs(grid, i, j-1, rows, cols);
// 		dfs(grid, i, j+1, rows, cols);
// 	}
// }


class Solution{
    public int numIslands(char[][] grid){
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == '1'){
                    res++;
                    bfs(grid, i ,j);
                }
        }
        
        return res;
    }
    
    private void bfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        
        int rows = grid.length, cols = grid[0].length;
        
        Queue<int[]> q = new LinkedList<int[]>();
        
        q.offer(new int[]{i, j});
        int[] idx = new int[0];
        
        while(!q.isEmpty()){
            idx = q.poll();
            
            if(idx[0] > 0 && grid[idx[0] - 1][idx[1]] == '1'){
                q.offer(new int[]{idx[0]-1, idx[1]});
                grid[idx[0] - 1][idx[1]] = '0';
            }
            
            if(idx[0] < rows - 1 && grid[idx[0] + 1][idx[1]] == '1'){
                q.offer(new int[]{idx[0]+1, idx[1]});
                grid[idx[0] + 1][idx[1]] = '0';
            }
            
            if(idx[1] > 0 && grid[idx[0]][idx[1] - 1] == '1'){
                q.offer(new int[]{idx[0], idx[1]-1});
                grid[idx[0]][idx[1] - 1] = '0';
            }
            
            if(idx[1] < cols - 1 && grid[idx[0]][idx[1] + 1] == '1'){
                q.offer(new int[]{idx[0], idx[1]+1});
                grid[idx[0]][idx[1] + 1] = '0';
            }
        }
    }
}
