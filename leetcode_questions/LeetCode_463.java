/*
方法一：就是遍历每个1，判断当前1的上下左右是什么，是0或者超出矩阵了就是说明有了一个新的边界

方法二：算出格子数，以及右邻居和下邻居的个数
然后# of islands * 4 - # of neighbours * 2
因为每个格子4条边，如果有右邻居，则总边数要－2，因为中间那条边是覆盖的，一下损失两条边
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null) return 0;
        if(grid[0] == null) return 0;
        int edges = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    
                    //up
                    if(i-1 < 0) edges++;
                    else if(grid[i-1][j] == 0) edges++;
                    
                    //down
                    if(i+1 > grid.length-1) edges++;
                    else if(grid[i+1][j] == 0) edges++;
                    
                    //left
                    if(j-1 < 0) edges++;
                    else if(grid[i][j-1] == 0) edges++;
                    
                    //right
                    if(j+1 > grid[i].length-1) edges++;
                    else if(grid[i][j+1] == 0) edges++;
                }
            }
        }
        return edges;
    }
}

// class Solution {
//     /// # of islands * 4 - # of neighbours * 2
//     /// Time: O(MN)
//     /// Space: O(1)
    
//     public int islandPerimeter(int[][] grid) {
//         int numIsland = 0;
//         int neighbour = 0;
        
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(grid[i][j] == 1){
//                     numIsland++;
//                     //rigth neighbour, each concated neighbour will "loss" one side
//                     if(i < grid.length-1 && grid[i+1][j] == 1) neighbour++;
//                     //down neighbour
//                     if(j < grid[0].length-1 && grid[i][j+1] == 1) neighbour++;
//                 }
//             }
//         }
        
//         return 4 * numIsland - neighbour * 2;
//     }
// }
