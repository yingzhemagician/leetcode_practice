/*
思路就是，一个元素一个元素往子集里面加
一开始res是[ [] ]
    遍历元素1，新增集合为[1]
res变为[ [], [1]]
    遍历元素2， 新增集合为[2], [1,2]
res变为[ [], [1], [2], [1,2]]
    遍历元素3，新增集合为[3], [1,3], [2,3], [1,2,3]

res最终是[ [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]

resDiff记录没新增一个元素而导致新增的子集，因此每次大循环完都要clear它
对于每个元素都要遍历一下当前res中的每个existingSubSet，先复制一下，然后往付出来的list里加元素
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        if(nums.length == 0) return res;
        
        List<List<Integer>> resDiff = new ArrayList<>();
        
        for(int i : nums){
            for(List<Integer> existingSubSet : res){
                List<Integer> updateSubSet = new ArrayList<>(existingSubSet);
                updateSubSet.add(i);
                resDiff.add(updateSubSet);
            }
            
            res.addAll(resDiff);
            resDiff.clear();
        }
        return res;
    }
}
