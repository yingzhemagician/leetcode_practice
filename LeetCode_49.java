class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap();
        
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            
            if(map.containsKey(sorted))
            {
                List<String> temp = map.get(sorted);
                temp.add(str);
                map.put(sorted, temp);
            }
            else{
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                map.put(sorted, newList);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}