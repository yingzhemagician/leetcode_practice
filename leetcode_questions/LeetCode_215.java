/*
kth largest element in the sorted order, not the kth distinct element.
因此可以用快排思想。[6,6,6,6]第二大的数还是6

利用快速排序的思想来找，快排每次找到的分割点就是该位置应该放置的数
找到分割点后，判断分割点距离末尾有多远，如果正好是k，那么已经找到了，返回
如果比k大，说明第k大的数在分割点右边，下次对右边进行快排
如果比k小，说明第k大的数在分割点左边，下次对左边进行快排
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        
        //此时的nums.length-k就是从后往前数第k大的意思，也就是那个数的下标
        return findHelper(nums,0, nums.length-1, nums.length-k);
  }

  public int findHelper(int[] nums, int start, int end, int k){
      if(start == end)
          return nums[k];

      int left = start, right = end;
      int midNum = nums[start + (end - start)/2];

      while(left <= right){
          while(left <= right && nums[left] < midNum) left++;
          while(left <= right && nums[right] > midNum) right--;
          //swap
          if(left <= right){
              int temp = nums[left];
              nums[left] = nums[right];
              nums[right] = temp;
              left++;
              right--;
          }
      }
      
      //此时left在right右边一个
      if(k <= right) return findHelper(nums, start, right, k);
      if(k >= left) return findHelper(nums, left, end, k);
      return nums[k];   
    }
}
