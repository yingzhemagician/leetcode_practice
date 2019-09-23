/*
很简单
先判断输入是否有效
然后设置一个idx指针，这个idx从1开始遍历，idx指向该位置最终应该是什么

循环中i也是从1开始遍历，每次对比i和i-1，如果不一样，那么i指向的那个元素就可以赋值给idx，然后idx就可以后移
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        int idx = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}
