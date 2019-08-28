/*
可以反复看
图的结构是Map<节点，<邻居，权重(临时结果值)>> 
最后的结果就是x到y的路径上的权重的乘积

遍历equations，取出x,y,v
然后把x,y放进graph，如果此时x,y没在map里就新建一个hashmap，然后把y,x,v,1/v，放进hashmap
此时图已经建立好

然后遍历queries
获取x,y

如果图里不包含x,y，就直接在res[]里写上-1
都包含的话就计算一下x/y的值
最后返回res

    除法
    如果x和y一样返回1
    然后把被除数x放到visited
    然后遍历x的邻居，如果邻居已经在visited里了就跳过，不在就加进去

*/
class Solution {
    Map<String, HashMap<String, Double>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int i = 0;
        for(List<String> eq : equations){
            String x = eq.get(0);
            String y = eq.get(1);
            double v = values[i++];
            
            graph.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, v);
            graph.computeIfAbsent(y, l -> new HashMap<String, Double>()).put(x, 1.0/v);
        }
        double[] res = new double[queries.size()];
        i = 0;
        
        for(List<String> qu : queries){
            String x = qu.get(0);
            String y = qu.get(1);
            
            if(!graph.containsKey(x) || !graph.containsKey(y))
                res[i++] = -1.0;
            else
                res[i++] = divide(x, y, new HashSet<String>());
        }       
        return res;
    }

    private double divide(String x, String y, Set<String> visited){
        if(x.equals(y)) return 1.0;
        visited.add(x);
        
        for(String node : graph.get(x).keySet()){
            if(visited.contains(node))
                continue;
            visited.add(node);
            double d = divide(node, y, visited);
            if(d > 0)
                return d*graph.get(x).get(node);
        }
        return -1.0;
    }
}
