/*
二分法查找数组翻折点
就简单的二分法去找就好
如果mid 在left 和 right的中间，那么返回left
如果mid比left大，但是也大于right，left = mid + 1，因为翻折点（最小值）肯定在mid右边
如果mid比left和right都小，name right = mid，因为翻折点（最小值）在mid或者mid左边

*/

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int left = 0, right = nums.length-1;
        
        while(left <= right){
            int mid = left+(right-left)/2;
            
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) return nums[left];
            else if(nums[left] <= nums[mid] && nums[mid] >= nums[right]) left = mid+1;
            else if(nums[left] >= nums[mid] && nums[mid] <= nums[right]) right = mid;
        }
        return nums[left];
    }
}
