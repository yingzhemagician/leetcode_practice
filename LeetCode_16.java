class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(target - res);
        int newDiff = diff;
        int sum = res;
        
        for(int i = 0; i < len; i++){
            for(int j = i+1, k = len - 1; j < k;){
                sum = nums[i] + nums[j] + nums[k];
                newDiff = Math.abs(target - sum);
                if(newDiff < diff){
                    res = nums[i] + nums[j] + nums[k];
                    diff = newDiff;
                }
                
                if(sum < target) j++;
                else if(sum > target) k--;
                else return sum;
            }
        }
        return res;
    }
}