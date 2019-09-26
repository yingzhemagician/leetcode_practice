/*
挺妙的
就是用map记录<从0到i的和，该和出现的次数>，同一个和可能出现了很多次
只要用sum1 - sum2就能得到任何从i到j的和
*/

class Solution {
   public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int prefixSum = 0;
        map.put(0,1);
       
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k))
                res += map.get(prefixSum - k);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            
        }
        return res;
    }
}
