class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int rightindex = searchRightIndex(nums, 0, nums.length - 1, target);
        if (rightindex < 0 || nums[rightindex] != target)
            return result;
        result[0] = searchLeftIndex(nums, 0, rightindex, target);
        result[1] = rightindex;
        return result;
    }
    
    public int searchRightIndex(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }

    public int searchLeftIndex(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}