/*
就是双重遍历，遇到x就DFS进去把所有X都改掉

follow up的话就是条件判断一下，如果X的左边和上边都没有X就count++，自己想的，应该也对
*/

class Solution {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return 0;
        
        int count = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    count++;
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || 
           j < 0 || j >= board[0].length || board[i][j] != 'X') return;

        board[i][j] = '#';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}

// class Solution{
//     public int countBattleships(char[][] board) {
//         int count = 0;
        
//         for(int i = 0; i < board.length; i++){
//             for(int j = 0; j < board[0].length; j++){
//                 if(board[i][j] == 'X'){
//                     if(i == 0 && j == 0) count++;
//                     else if(i == 0){
//                         if(board[i][j-1] != 'X') count++;
//                     }
//                     else if(j == 0){
//                         if(board[i-1][j] != 'X') count++;
//                     }
//                     else if(board[i][j-1] != 'X' && board[i-1][j] != 'X'){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
//     }    
// }
