class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        
        if(nums[0] > nums[1]) return 0;
        
        int i = 1;
        
        for(; i < nums.length - 1; i++)
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        
        return i;
    }
}