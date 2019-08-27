/*
Google OA
使用map记录<深度，当前深度的最长文件路径>
先用"\n"分割输入

然后遍历这个String List
    对于每个str，先看"\t"的最后一次索引，注意\t和\n都是转义字符所以都是一个字符
    \t的索引是-1说明没找到，就算是第0层
    \t的索引是0，说明就是索引0是\t，就算是第1层
    然后从索引+1的位置开始到字符串最后计算出长度，这个长度可能是文件夹名可能是文件名
    
    如果str包含.就是文件，获取出层路径长度，再算出完整长度，然后和res比较，选长的
    如果不是文件，就是文件夹，这个文件夹又是新的一层，长度是上一层的长度加上这一层的长度，注意还要加个1位空行符号长度
*/

class Solution {
    public int lengthLongestPath(String input) {
        String[] list = input.split("\n");
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        
        int res = 0;
        for(String str : list){
            int depth = str.lastIndexOf("\t")+1;
            int len = str.length() - depth;
            
            if(str.contains(".")){
                int dirLength = map.get(depth);
                res = Math.max(res, dirLength+len);
            }
            else{
                map.put(depth+1, map.get(depth)+len+1);
            }
        }
        return res;
    }
}
