/*
错位词
建立一个hashmap <单词的顺序序列，属于该序列的单词list>

然后遍历strs，每得到一个str先换成charArray然后sort，然后sort的结果新建一个sortedStr
判断这个sortedStr在不在map里，在的话，就把没排序的str放进list
                            不在的话，就新建一个<sortedStr，list>

最后把map.values()都放进res就行了
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap();
        
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            
            if(map.containsKey(sorted)){
                List<String> temp = map.get(sorted);
                temp.add(str);
                //map.put(sorted, temp); 可以省略这句，因为get出来的是一个list的引用
            }
            else{
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                map.put(sorted, newList);
            }
        }
        
        for(List<String> list : map.values())
            res.add(list);

        return res;
    }
}
