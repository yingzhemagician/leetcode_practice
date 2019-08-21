/*
最终简化为求[1, n]闭区间内的完全平方数个数，可以暴力求，可以直接对n开方求
可以画图找规律
规律就是，在完全平方数位置的灯泡最后会亮
因为，第一次操作是点亮所有

然后比如第36个灯泡只有在(1,36), (2,18), (3,12), (4,9), (6,6)这些round才被拨动
也就是36有这么多个因子，只有当round=因子的那一轮才有变化
而因子一般都是成对儿的，只有完全平方数才有一对儿特殊因子是两个数相同，也就是在特殊因子轮时被动的那一次之后没有对称的改动了

因此就是找36里面有多少个完全平方数
*/

class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}

// class Solution {
//     public int bulbSwitch(int n) {
//         int res = 1;
        
//         while(res * res <= n)
//             res++;
        
//         return res - 1;
//     }
// }
