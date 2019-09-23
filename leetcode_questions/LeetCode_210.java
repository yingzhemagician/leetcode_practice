/*和前面那个一样，注意谁是先谁是后，相当于把入度为0的点“按顺序”放进res
因为第一个值是高级课，第二个是低级课，所以是反向放，图中的边是0——>1 最终画出的上课线应该是1完了上0
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        
        //建图
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            
            if(!map.containsKey(course))
                map.put(course, new ArrayList<>());
            map.get(course).add(preCourse);
            inDegree[preCourse]++;
        }
        
        int idx = numCourses - 1;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < inDegree.length; i++)
            if(inDegree[i] == 0){
                q.offer(i);
                res[idx--] = i;
            }
                

        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            
            if(!map.containsKey(course)) continue;
            
            List<Integer> preCourse = map.get(course);
            
            for(int i = 0; i < preCourse.size(); i++){
                int pcourse = preCourse.get(i);
                
                inDegree[pcourse]--;
                if(inDegree[pcourse] == 0){
                    q.offer(pcourse);
                    res[idx--] = pcourse;
                }
            }
        }
        if(count == numCourses)
            return res;
        
        res = new int[0];
        return res;
    }
}
