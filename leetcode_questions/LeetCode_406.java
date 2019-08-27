/*
先按身高排序，身高一样就把第二个数小的放在前面

然后遍历排好序的数组，将其插入一个新的arraylist，最后再换会数组

比较不好想的是为什么此时按顺序“插入”arraylist就是答案
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return people;
        
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2){
                return p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1];
            }
        });
        
        List<int[]> temp = new ArrayList<int[]>();
        
        for(int [] p : people){
            temp.add(p[1], p);
        }
        
        int res[][] = new int[people.length][2];
        for(int i = 0; i < temp.size(); i++)
            res[i] = temp.get(i);
        
        return res;
    }
}
