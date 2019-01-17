public class leetCode_78 {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> blank = new ArrayList<>();
        res.add(blank);
        if(len == 0) return res;

        for(int i : nums){
            List<List<Integer>> newSubSets = new ArrayList<>();
            for(List<Integer> subSet : res){
                List<Integer> subSetCopy = new ArrayList<>(subSet);
                subSetCopy.add(i);
                newSubSets.add(subSetCopy);
            }
            res.addAll(newSubSets);
        }
        return res;
    }
}
