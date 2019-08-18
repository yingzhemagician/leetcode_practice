/*
最右边一列，Hamming距离累加是：1到两个0，是2；其实最后就是统计每列1的个数，然后每列乘以0的个数
不要相信oj的时间判断
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        if(nums == null) return 0;
        
        int res = 0, n = nums.length;
        
        for(int i = 0; i < 32; i++){
            int countOf1 = 0;
            int mask = 1 << i;
            for(int num : nums){
                if((num & mask) > 0)
                    countOf1++;
            }
            res += countOf1*(n-countOf1);
        }
        
        return res;
    }
}
