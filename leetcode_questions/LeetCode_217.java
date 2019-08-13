/*
思路一：直接用set，但是会慢一些，到9ms
思路二：
先排序，然后遍历看有没有nums[i]等于nums[i+1]的
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1)
            return false;
        
        Arrays.sort(nums);
        
        for(int i=0; i<= nums.length-2; i++)
            if(nums[i] == nums[i+1])
                return true;

        
        return false;
    }
}
