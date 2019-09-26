/*
可以暴力解
但简单解法是利用排序后升序特性，双指针，end每次都是指的是最长的那个边，也就是从数组的最后往前走
然后left就是0开始，right就是end-1开始
如果left+right已经大于end了，那么right不变的话，left往右所有的值都可以和前right和end组成三角形，之后right--
如果不大于end，那么说明left需要增大
*/

class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3)
            return 0;
        Arrays.sort(nums);
        
        int res = 0;
        
        for(int end = nums.length - 1; end >= 2; end--){
            int last = nums[end];
            int left = 0;
            int right = end - 1;
            
            while(left < right){
                int a = nums[left];
                int b = nums[right];
                if(a + b > last){
                    res += right - left;
                    right--;
                }else
                    left++;
            }
        }
        return res;
    }
}
