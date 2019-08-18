/*
方法一：暴力搜索，遍历1，在2中找坐标，然后找右边第一个大于它的数
        但是如果改成边遍历边查找反而快
方法二：把2简历成map，也就是<元素，下标>，或者用长为1000的数组替代，然后遍历1，在map中直接找到位置之后再遍历右边
方法三：用map+stack，map<num，比num大的下一个> stack里放的是到目前位置，未找到next great的数
       进栈前要“循环判断”：当前num是不是比栈顶大？
            是的话，就要把<栈顶，num>放进map，然后进栈
            不是的话就直接进栈
       遍历完之后栈不为空，所以剩下的都弹出来以<pop, -1>的形式放进map
       不放的话后面转成res的时候就要判断
                                                
*/
//方法一，边遍历边查找
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int [] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int index = findPos(nums1[i],nums2);
            res[i] = nextLarge(index ,nums2);
        }
        return res;
    }
    
    public int findPos(int item, int[] nums2){
        for(int i = 0; i < nums2.length; i++)
            if(item == nums2[i])
                return i;
        return -1;
    }
    
    public int nextLarge(int index,int [] nums2){
        int max = nums2[index];
        for(int i = index+1; i < nums2.length; i++)
            if(nums2[i] > max)
                return nums2[i];
        return -1;
    }
}

//方法三，map+stack
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
//             return new int[0];
        
//         int[] res = new int[nums1.length];
//         Map<Integer, Integer> map = new HashMap<>();
//         Stack<Integer> stack = new Stack<>();
        
//         for(int num : nums2){
//             while(!stack.isEmpty() && stack.peek() < num){
//                 map.put(stack.pop(), num);
//             }
//             stack.push(num);
//         }
        
//         while(!stack.isEmpty())
//             map.put(stack.pop(), -1);
        
//         for(int i = 0; i < nums1.length; i++)
//             res[i] = map.get(nums1[i]);
        
//         return res;
//     }
// }
