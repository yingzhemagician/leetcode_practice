/*
就是先查第一个数，从它的编码来看这个它是哪类
在检测属于哪类时要严格按照要求，如果前5位以上都是1或者就第一位是1，那么这个头就是违法的，type就错了返回
其他的按照位运算去分类

得到的分类结果就意味着接下来要验证几个数，比如type是3，那么就要验证下面三个数，于是进入后三次循环，checkTimes是三次
    每次都判断当前data[i]是不是10开头，是的话，检测成功，type就要--，这里我把type换成了checkTimes易读
    如果在检查中（checkTimes仍大于0），data[i]不是10开头，那就错了
所有data都检查完了，看checkTimes是不是归零了，归零了就对了，没归零说明data最后缺数没验证完
*/

class Solution {
    public boolean validUtf8(int[] data) {
        int checkTimes = 0;
        
        for(int i = 0; i < data.length; i++){
            if(checkTimes > 0){
                if((data[i] & 0b10000000) == 0b10000000)
                    checkTimes--;
                else
                    return false;
            }
            else{
                int headType = getHeadType(data[i]);
                if(headType < 0)
                    return false;
                checkTimes = headType;
            }
        }
        return checkTimes == 0;
    }
    
    private int getHeadType(int num){
        if((num & 0b11111000) == 0b11111000) return -1;
        if((num & 0b11110000) == 0b11110000) return 3;
        if((num & 0b11100000) == 0b11100000) return 2;
        if((num & 0b11000000) == 0b11000000) return 1;
        if((num & 0b10000000) == 0b10000000) return -1;
        
        return 0;
    }
}
