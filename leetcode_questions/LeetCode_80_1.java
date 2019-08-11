class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <= 2) return len;
        int count = 0, slow = 1;
        
        for(int fast = 1; fast < len; fast++){
            if(nums[fast] == nums[fast-1]){
                count++;
                if(count < 2){
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            else{
                count = 0;
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}