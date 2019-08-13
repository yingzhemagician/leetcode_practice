/*
用双指针
首先建立结果集res，然后判断nums有效性
然后数组排序，排序后才方便用双指针

遍历nums，因为是固定一个，后面用双指针，所以i不能超过len-2
因为是排序好的，而且三个数总和等于0，如果nums[i]已经大于0就不用找了，直接退出了
从i=1开始，每次把nums[i]和nums[i-1]比较，如果相等了就continue，因为只要唯一的结果

然后，j从i+1开始，k从len-1开始，target就是负的nums[i]
循环夹紧j和k，如果nums[j]+nums[k]>target，那么k--
            如果nums[j]+nums[k]<target，那么j++
            否则 说明找到了一个结果，加进res里面
            
                然后更新j和k，注意nums[j]不等于nums[j-1]，nums[k]不等于nums[k+1]，且j<k
                这个判断写在“找到结果的情况”中就行
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++){
            if (nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int j = i+1, k = nums.length-1;
            int target = -nums[i];
            
            while(j < k){
                if (nums[j]+nums[k] > target)
                    k--;
                else if(nums[j]+nums[k] < target)
                    j++;
                else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
                
            }
        }
        return res;
    }
}
