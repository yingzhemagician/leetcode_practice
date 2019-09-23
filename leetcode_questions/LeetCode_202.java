//思路就是外层循环判断n到没到1，内层就是遍历当前n的每一位来算sum
//时间复杂度O(1)吧，常数时间
//空间复杂度。。。我感觉也是O(1)，网上说O(n)

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        
        while(n != 1){
            int sum = 0;
            
            //遍历每一位
            while(n > 0){
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            
            n = sum;
            
            if(visited.contains(sum))
                break;
            visited.add(sum);
        }
        return n == 1;
    }
}
