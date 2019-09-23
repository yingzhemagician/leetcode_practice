/*
DFS
首先建立res，然后判断输入有效性
然后建立按键数字与字母的映射，为了简化，就把mapping的起始坐标0当成第一个键，然后dfs

dfs参数是：输入字串digits，映射，接下来数字的位置，当前组成的字串temp，结果集res

每次dfs先判断index是不是已经超过了digits的长度，如果等于了就说明已经完成了搜索，把temp换成string加进res

然后获取该按键数字对应的字符，方法时得到digits的对应字符，转换成字符串，再转换成数字
digits.charAt(index)得到字符
String.valueOf(digits.charAt(index))变成字串
Integer.parseInt(String.valueOf(digits.charAt(index)))变成整数
最后-2获得在mapping中的位置

然后获取mapping中的字符组合，遍历这些字符
    每遍历一个，就先把它加到temp上，然后继续dfs，参数index要加1
    dfs之后就要把temp中刚刚加上的那个字符删掉
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<String>();
        
        if(digits.length() == 0) return res;
        
        String[] mapping = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        dfs(digits, mapping, 0, new StringBuilder(), res);
        
        return res;
    }

    private void dfs(String digits, String[] mapping, int index, StringBuilder temp, List<String> res){
        if(index == digits.length()){
            res.add(temp.toString());
            return;
        }  
        int mapIdx = (digits.charAt(index) - '0') - 2;
        String charOnButton = mapping[mapIdx];
        
        for(char c : charOnButton.toCharArray()){
            temp.append(c);
            dfs(digits, mapping, index+1, temp, res);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
