/*
用一个长度为2的数组记录结果的下标
建立HashMap

遍历数组nums，判断target-nums[i]在不在map里，在的话就找到了
不在的话，把nums[i]和i放进map
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if (map.containsKey(diff)) {
                indices[0] = map.get(diff);
                indices[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return indices;
    }
}
