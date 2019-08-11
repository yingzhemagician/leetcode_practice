class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
        
        Arrays.sort(nums);
        
        if(nums.length < 4) return res;
        
        int p = 0, q = nums.length - 1, sum = 0;
        
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                p = j + 1;
                q = nums.length - 1;
                while(p < q){
                    sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        while(p < q){
                            p++;
                            if(nums[p] != nums[p-1])
                                break;
                        }
                            
                    }
                    else if(sum < target){
                        while(p < q){
                            p++;
                            if(nums[p] != nums[p-1])
                                break;
                        }
                    }
                    else{
                        while(p < q){
                            q--;
                            if(nums[q] != nums[q+1])
                                break;
                        }  
                    }
                    
                }
                while(nums[j+1] == nums[j] && j < nums.length - 2)
                    j++;
            }
            while(nums[i+1] == nums[i] && i < nums.length - 3)
                    i++;
        }
        
        return res;
    }
}