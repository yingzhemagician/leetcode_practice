//Non-Recursive
public class leetcode_46_1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        res.add(first);

        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> newRes = new ArrayList<>();

            for(List<Integer> temp: res){
                int size = temp.size() + 1;

                for(int j = 0; j < size; j++){
                    List<Integer> newTemp = new ArrayList<>(temp);
                    newTemp.add(j, nums[i]);
                    newRes.add(newTemp);
                }
            }
            res = newRes;
        }
        return res;
    }
}
