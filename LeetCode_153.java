class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) return nums[left];
            else if(nums[left] <= nums[mid] && nums[mid] >= nums[right]) left = mid + 1;
            else if(nums[left] >= nums[mid] && nums[mid] <= nums[right]) right = mid;
        }
        return nums[left];
    }
}