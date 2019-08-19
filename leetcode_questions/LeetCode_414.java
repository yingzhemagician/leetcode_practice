/*
先排序，然后判断个数，个数小于等于2的直接返回最大值
然后设一个临时变量candidate，以及计数器count记录遇到了几个不同的数

然后遍历数组
如果当前数和candidate不一样，就count++，candidate就是当前数

遍历完，判断count是不是3
*/

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int maximum = nums[nums.length - 1];
        
        if(nums.length <= 2) return maximum;
        
        int candidate = maximum, count = 1;
        
        for(int i = nums.length - 2; i >= 0 && count < 3; i--){
            if(nums[i] != candidate){
                count++;
                candidate = nums[i];
            }  
        }
        
        if(count != 3)
            return maximum;
        return candidate;
    }
}
