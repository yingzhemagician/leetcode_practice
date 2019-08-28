/*
标准二分法
递归与非递归
*/

// class Solution {
//     public int search(int[] nums, int target) {
//         if(nums == null || nums.length == 0) return -1;
        
//         int left = 0, right = nums.length-1;
        
//         while(left <= right){
//             int mid = left+(right-left)/2;
            
//             if(nums[mid] == target) return mid;
//             else if(nums[mid] > target)
//                 right = mid-1;
//             else
//                 left = mid+1;
//         }
        
//         return -1;
//     }
// }

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    private int binarySearch(int[] nums, int left, int right, int target){
		if(left > right)
			return -1;
        
		int mid = left+(right-left)/2;

		if(nums[mid] == target) return mid;
		else if(nums[mid] > target)
			return binarySearch(nums, left, mid-1, target);
		else 
			return binarySearch(nums, mid+1, right, target);	
    }
}
