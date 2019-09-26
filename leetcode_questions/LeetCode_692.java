/*
要知道每个词的内容和频率，肯定要用映射，但是之后要对这个映射排序，因此自然想到映射变成Node节点，放进pq里排序
小的在前面，因为当size大于K时，就要弹出频率小的，如果用单向优先队列，那只能弹出队首
最后遍历完map之后，弹出队列，弹出顺序是从小到大，所以插入要插入在头部
*/

class Solution {
    
    class Node {
        String word;
        int freq;
        Node(String w, int f) {
            word = w;
            freq = f;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override//频率小的在前面，因为之后要做弹出操作
            public int compare(Node a, Node b) {
                return a.freq == b.freq ? b.word.compareTo(a.word) : a.freq - b.freq;
            }
        });
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        for(String word : map.keySet()) {
            pq.offer(new Node(word, map.get(word)));
            if(pq.size() > k)
                pq.poll();
        }
        
        List<String> res = new LinkedList<>();
        
        while(!pq.isEmpty())
            res.add(0, pq.poll().word);
        
        return res;
    }
}
