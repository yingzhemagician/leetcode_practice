class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle.size() == 0) return 0;
        if(triangle.get(0).size() == 0) return 0;
        
        int level = triangle.size();
        int first = 0, last = 0;
        
        for(int i = 1; i < level; i++){
            List<Integer> temp = triangle.get(i-1);
            List<Integer> current = triangle.get(i);
            
            first = current.get(0) + temp.get(0);
            last = current.get(current.size()-1) + temp.get(temp.size()-1);
            
            current.set(0, first);
            current.set(current.size()-1, last);
            
            for(int j = 1; j < current.size()-1; j++){
                current.set(j, current.get(j)+Math.min(temp.get(j-1), temp.get(j)));
            }
        }
        
        int min = triangle.get(triangle.size()-1).get(0);
        
        for(int x:triangle.get(triangle.size()-1)){
            if(x < min)
                min = x;
        }

        return min;
        
    }
}