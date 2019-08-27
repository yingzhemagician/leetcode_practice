/*
遍历数组
    先取得这个元素值对应的坐标值idx，是abs(nums[i])-1，要用绝对值因为nums[i]此时可能是复数，还得减一来对应
    然后看idx位置是不是为负，为负数了，那么idx+1这个值放进res
    最后把idx位置的的元素取负
    每遇到一个元素，将其值对应的位置上的那个元素变复数（利用题目性质，元素值在[1,n]之间）
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null) return res;
        
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            
            if(nums[idx] < 0)
                res.add(idx+1);
            nums[idx] = -nums[idx];
        }
        
        return res;
    }
}
