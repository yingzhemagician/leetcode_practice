/*
寻找有向图中的环
课程依赖就是图的边 1->2，2是1的preCourse
所以可以用map记录这个图，key就是高级课，value是它的那些先导课，因此有些高级课可能就不会再map里
另外有一个记录图中每个点“入度”的数组
因为题中课程号就是0~n-1，所以简化了

遍历二维数组去填充map，并在入度数组中记录

要想看图中有没有环，方法是，找一个 入度是0的点，从它开始，每次删除改点和它射出的边
如果没环的话，所有点都会被删除，也就是入度数组中全是0，或者记录一下删除的节点的个数，不等于原始个数就gg

可以使用队列，先放一个入度为0的高级课进去，然后弹出，遍历它的 pre课，在pre课对应的入度数组中 减入度
其实就是相当于在删除边
同时维护一个count记录有多少个点能达到入度是0
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int[] inDegree = new int[numCourses];
        
        //建图
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            
            if(!map.containsKey(course))
                map.put(course, new ArrayList<>());
            map.get(course).add(preCourse);
            inDegree[preCourse]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        //所有入度为0的点加入到队列
        for(int i = 0; i < inDegree.length; i++)
            if(inDegree[i] == 0)
                q.offer(i);

        int count = 0;
        while(!q.isEmpty()){
            //取出高级课
            int course = q.poll();
            count++;
            
            if(!map.containsKey(course)) continue;
            
            List<Integer> preCourses = map.get(course);
            
            for(int i = 0; i < preCourses.size(); i++){
                int pcourse = preCourses.get(i);
                
                inDegree[pcourse]--;
                if(inDegree[pcourse] == 0)
                    q.offer(pcourse);
            }
        }
        return count == numCourses;
    }
}
