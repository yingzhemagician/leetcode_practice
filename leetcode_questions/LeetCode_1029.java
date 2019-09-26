/*
其实考的是排序
假设所有人都去城市1，然后从中挑一半人去城市2，也就是看谁的 花费2-花费1 最小
选较小的一半人去就行了
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                int d1 = a[1] - a[0];
                int d2 = b[1] - b[0];
                
                return d1 - d2;
            }
        });

        int len = costs.length, res = 0;
        for(int i = 0; i < len/2; i++)
            res += costs[i][1] + costs[len-1-i][0];
        
        return res;
    }
}
