class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> tempSets = new HashSet<Character>();
        
        //row
        for(int i = 0; i < 9; i++){
            tempSets.clear();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(tempSets.contains(board[i][j]))
                        return false;
                    else
                        tempSets.add(board[i][j]);
                }
            }
        }
        
        //column
        for(int j = 0; j < 9; j++){
            tempSets.clear();
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(tempSets.contains(board[i][j]))
                        return false;
                    else
                        tempSets.add(board[i][j]);
                }
            }
        }
        
        //block
        for(int m = 0; m < 3; m++){
            for(int n = 0; n < 3; n++){
                tempSets.clear();
                
                //each digit in the block
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char digit = board[3*m+i][3*n+j];
                        if(digit != '.'){
                            if(tempSets.contains(digit))
                                return false;
                            else
                            tempSets.add(digit);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}