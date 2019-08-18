/*
复习方法一
方法一：就是按照右上和左下去遍历，这个解法在判断边界时挺妙的
    比如，向右上走的时候，碰到边界有三种情况
    1. 打到上边界，所以i此时是0      ----需要换方向，且j+1
    2. 打到右边界，所以j此时是width-1----需要换方向，且i+1
    3. 打到右上角，i是0，j是width-1  ----需要换方向，且i+1
    所以if只判断第一种情况就行了，直接判断j能不能+1
    
    整体思路就是设一个总count，每防止一个新的数就count++，然后设一个方向flag
方法二：有点慢，自己想的，别看了
*/

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        
        int i = 0, j = 0, height = matrix.length, width = matrix[0].length;
        int[] result = new int[height * width];
        int count = 0;
        boolean up = true;
        
        while (count < result.length){//放完之后才++，所以此处要<
            result[count++] = matrix[i][j];
            if(up){ 
                while (i > 0 && j < width-1)
                   result[count++] = matrix[--i][++j];

                if(j+1 < width)
                    j++;
                else
                    i++;
                up = false;
            }else{
                while(i < height-1 && j > 0)
                    result[count++] = matrix[++i][--j];

                if(i+1 < height)
                    i++;
                else
                    j++;
                up = true;
            }
        }
        return result;
   }
}

// class Solution {
//     public int[] findDiagonalOrder(int[][] matrix) {
//         if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
//             return new int[0];
//         }
        
//         int dir = 0;
//         List<Integer> res = new ArrayList<>();
        
//         for(int col = 0; col <= matrix[0].length-1; col++){
//             List<Integer> tempList = new ArrayList<>();
//             int i = 0, j = col;
//             while(i <= matrix.length-1 && j >= 0){
//                 tempList.add(matrix[i++][j--]);
//             }
//             if(dir == 0){
//                 Collections.reverse(tempList);
//                 dir = 1;
//             }
//             else{
//                 dir = 0;
//             }
//             res.addAll(tempList);
//         }
        
//         for(int row = 1; row <= matrix.length-1; row++){
//             List<Integer> tempList = new ArrayList<>();
//             int j = matrix[0].length-1, i = row;
//             while(i <= matrix.length-1 && j >= 0){
//                 tempList.add(matrix[i++][j--]);
//             }
//             if(dir == 0){
//                 Collections.reverse(tempList);
//                 dir = 1;
//             }
//             else{
//                 dir = 0;
//             }
//             res.addAll(tempList);
//         }
        
//         int[] result = new int[res.size()];
//         for(int i = 0; i < result.length; i++){
//             result[i] = res.get(i);
//         }
//         return result;
//     }
// }


