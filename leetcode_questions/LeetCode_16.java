/*
还是双指针
首先数组排序
然后初始化res就是前三个数字之和，初始化diff就是前三个数和target的差值
初始化tempDiff和tempSum

进入循环，然后双指针，首先固定i，然后j是i+1，k是len-1
每一对新的j和k都要计算一下当前的tempSum和tempDiff
如果tempDiff小于diff，那么就遇到了更接近的和，因此更新res和diff

如果tempSum比target小，就j右移
如果tempSum比target大，就k左移
如果正好相等，直接返回tempSum
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - res);
        int tempDiff = diff, tempSum = res;
        
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1, k = nums.length - 1; j < k;){
                tempSum = nums[i] + nums[j] + nums[k];
                tempDiff = Math.abs(target - tempSum);
                
                if(tempDiff < diff){
                    res = tempSum;
                    diff = tempDiff;
                }
                
                if(tempSum < target) j++;
                else if(tempSum > target) k--;
                else return tempSum;
            }
        }
        return res;
    }
}
