/*
整体思路是，先看结果是不是负数，然后取绝对值用除法算出整数部分，然后用取余的方式算小数部分
但是整数int的取值是-2147483648～2147483647，因此最小值取abs之后就越界了
所以先把被除数和除数换成abs long
然后算符号，然后算整数部分，加“.”
然后算小数部分（跟除法竖式差不多）
用map<余数, 小数位index>来记录是否见过这个余数
先算出余数然后进入循环，循环结束条件是余数为0
先把当前余数*10，再除以除数算出下次的余数
然后看map里有没有当前余数
    有的话说明这已经是开始循环的第一位了，因此在第一次遇到这个余数的index为insert"("
    在整个fracSb后面append")"
    
    没有的话，就把这个余数和fracIdx放入map，将当前余数除以除数的结果append到fracSb后面
    当前余数赋值为下个余数
    
最后把fracSb加入到.后面

*/

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long longNumerator = Math.abs((long)numerator);
        long longDenominator = Math.abs((long)denominator);
        
        StringBuilder sb = new StringBuilder();
        
        if((long) numerator*denominator < 0)
            sb.append("-");
        
        sb.append(longNumerator/longDenominator);
        
        long remainder = longNumerator%longDenominator;
        if(remainder == 0)
            return sb.toString();
        
        sb.append(".");
        
        StringBuilder fracSb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        
        int fracIdx = 0;
        
        while(remainder != 0){
            remainder *= 10;
            long nextRemainder = remainder%longDenominator;
            
            if(map.containsKey(remainder)){
                fracSb.insert(map.get(remainder), "(");
                fracSb.append(")");
                break;
            }
            map.put(remainder, fracIdx++);
            fracSb.append(remainder/longDenominator);
            remainder = nextRemainder;
        }
        
        sb.append(fracSb);
        return sb.toString();
    }
}
