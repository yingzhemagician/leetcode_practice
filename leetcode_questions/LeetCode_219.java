/*
tips:建立查找表，查找的是某个数据项的最新位置

建立HashMap<数组项, 该项最新出现的索引>

遍历数组，如果nums[i]不在map里，就加进去
        如果nums[i]在map里，就看i-map.get(nums[i])的差是不是小于等于k
            是的话就找到了，返回true
            不是的话就把新的<数组项, 该项最新出现的索引>放进map，相当于更新该项的最新位置
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int len = nums.length;
        
        if(len == 0 || len == 1)return false;
        
        for(int i = 0; i < len; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else{
                if(i - (int)map.get(nums[i]) <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }
}
