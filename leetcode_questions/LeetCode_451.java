/*
和统计k个出现频率最高的词那个题有点像

就是用map先统计字符和对应的次数
然后放进优先队列里，再输出，按照次数来append到sb里
*/

class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){
            public int compare(Character c1, Character c2){
                return map.get(c2) - map.get(c1);
            }
        });
        
        for(char c : map.keySet())
            pq.offer(c);
        
        while(!pq.isEmpty()){
            char c = pq.poll();
            for(int i = 0; i < map.get(c); i++)
                sb.append(c);
        }
        
        return sb.toString();   
    }
}
