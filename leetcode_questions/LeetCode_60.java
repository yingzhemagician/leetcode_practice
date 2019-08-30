/*
其实有点像找规律
整体思路是，把所有排列列出来之后，发现其实都是按照高位来“分组的”
比如，第一个数字是最高位
1开头->{后面有(n-1)!种可能}
2开头->{后面有(n-1)!种可能}
。。。
。。。
所以对于第一位，就是一共有n个组，每个组(n-1)!个candidates
那么先看k在哪个组，因为每个组有(n-1)!个，所以用k除以(n-1)!，也就是除以candidates的数量
找到组的序号idx，就可以找到list里idx对应的item，把它append到res后面，然后在list里删掉因为用过了
此时计算新的k，也就是最终的candidate在该组里的新序号，用k取模candidates数量得到新的k
每层candidates的数量也在变，变化规律是(n-1)! (n-2)! (n-3)!，也就是每次都要除以当前最高位的位数-1
当最高位已经是0了，就别除了因为已经是最后一次循环了而且不能除以0
*/
class Solution {
    public String getPermutation(int n, int k) {
        k--;//下标对齐
        
        List<Integer> list = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        
        for(int i = 1; i <= n; i++)
            list.add(i);
        
        int candidatesNumInGroup = 1;
        for(int i = 2; i < n; i++)
            candidatesNumInGroup *= i;
        
        for(int pos = n-1; pos >= 0; pos--){
            int idx = k / candidatesNumInGroup;
            res.append(list.get(idx));
            list.remove(idx);
            
            k = k % candidatesNumInGroup;
            if(pos != 0)
                candidatesNumInGroup = candidatesNumInGroup / pos;
        }
  
        return res.toString();
    }
}
