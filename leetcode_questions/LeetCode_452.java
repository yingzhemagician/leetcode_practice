/*
贪婪，和meeting room很像
先对气球区间排序，按结束点升序排序，起始点可以不管
然后第一个元素就是结束点最早的，从它开始遍历，只要后面的元素的起始点不超过刚才的结束点，就可以一箭干掉
如果超过了，那就需要加一箭，此时新的结束点就是当前气球的结束点

*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0)
            return 0;
        
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        
        int res = 1;
        int preEnd = points[0][1];
        
        for(int i = 1; i < points.length; i++){
            if(preEnd < points[i][0]){
                res++;
                preEnd = points[i][1];
            }  
        }
        return res;
    }
}
