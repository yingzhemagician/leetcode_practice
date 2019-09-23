/*
其实就是二分法的变种
正常二分法算出mid后，如果mid指向的值就是target那么就返回了成功了

如果不是，那么开始判断
如果mid指向的值小于right指向的值，说明右边是有序的
    如果tar在[mid]和[right]中间，说明tar就在右边，那么left就是mid+1
    如果不在，那么tar就在左边，right就是mid-1
否则说明左边是有序的
    如果tar在[left]和[mid]中间，说明tar就在左边，那么right就是mid-1
    如果不在，那么tar就在右边，left就是mid+1
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        
        while(left <= right){
            int mid = left+(right-left)/2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else 
                    right = mid - 1;
            }
            else{
                if(target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
