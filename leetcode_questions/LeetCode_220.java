/*
明白了，可以重复看
使用有序的set，java中的TreeSet的compare接口需要自己实现
此题中，有一个窗口从i到j，长度为k，实际是k-1，因为每次都要新加一个元素进来
       在这个窗口中维持一个TreeSet，TreeSet中判断元素重复的条件是：
                            如果元素x在某个元素i的[i-t, i+t]范围内，就加不进来
                            如果不在，就按大小顺序加进来就行
所以，在维持窗口长度k的同时向set里加东西，加不进去了就找到了
*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k == 0 || nums.length <= 1) return false;
        
        TreeSet<Integer> orderedSet = new TreeSet<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                long diff = (long)i1 - i2;
                if(Math.abs(diff) <= t){
                    return 0;
                }
                else{
                    return diff > 0 ? 1 : -1;
                }
            }
        }
        );
        
        for(int i = 0; i < nums.length; i++){
            if(!orderedSet.add(nums[i]))
                return true;
            if(i >= k)
                orderedSet.remove(nums[i - k]);
        }
        
        return false;
    }
}
