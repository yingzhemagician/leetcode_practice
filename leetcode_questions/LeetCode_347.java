/*
最大堆
先统计数字出现次数，用hashmap统计，遍历数组，然后计数

新建一个Node类，主要是已经熟悉了这种写法。然后遍历map把Node对象一个个写进优先队列里

然后输出前k个

面试telenav的时候有个思路是快排加二分，不知道有重复数字是行不行
每次快排，都把大于当前值得数都放到右边，一次分区后，如果当前值所在的位置左边有超过k个数，那么第k个一定在左边

另一种方法是桶排序，只是按照freq将相应的数字放进桶里，以链表形式，然后按k个输出，也挺好
*/

class Solution {
    
    class Node {
        int num;
        int freq;
        public Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        
        if(nums.length == 0) return res;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node node_1, Node node_2){
                return node_2.freq - node_1.freq;
            }
        });
        
        for(int num : map.keySet())
            pq.offer(new Node(num, map.get(num)));
        
        for(int i = 0; i < k; i++)
            res.add(pq.poll().num);
        
        return res;
    }
}


// class Solution {
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int num : nums)
//             map.put(num, map.getOrDefault(num, 0) + 1);
        
//         List<Integer>[] bucket = new List[nums.length + 1];
        
//         for (int num : map.keySet()) {
//             int freq = map.get(num);
//             if (bucket[freq] == null)
//                 bucket[freq] = new LinkedList<>();

//             bucket[freq].add(num);
//         }
        
//         List<Integer> res = new ArrayList<>();
//         for (int i = bucket.length - 1 ; i >= 0 ; i--) {
//             int j = 0;
//             while (bucket[i] != null && j < bucket[i].size() && k > 0) {
//                 res.add(bucket[i].get(j++));
//                 k--;
//             }
//         }
//         return res;
//     }
// }
