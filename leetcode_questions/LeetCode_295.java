/*
找一组数的中位数，中位数的意思是，如果一共有奇数个数，中位数就是中间那个。如果有偶数个，就是中间那两个的平均数

因此，用两个优先队列来存数列的前半部分和后半部分，相当于把数列对半劈开
优先队列是小的在前大的在后，所以第二个队列就存负数就行

比如 5，4，3
    -1 -2
注意如果是奇数的话就保证队列1长就行，return 队列1的 队首

addNum就是，加一个数到队列1里面，同时弹出一个变为负数之后放进队列2，如果队列1本来是偶数，那么add且poll之后，队列2就多一个，因此还要判断当队列1短的时候，队列2还要弹出一个放进队列1

findMedian就是，如果队列1长，就返回队列1的队首，如果一样长就返回队首之“差”的平均数

follow up
1. We can maintain an integer array of length 100 to store the count of each number along with a total count. Then, we can iterate over the array to find the middle value to get our median.
Time and space complexity would be O(100) = O(1).

2. In this case, we need an integer array of length 100 and a hashmap for these numbers that are not in [0,100].
*/

class MedianFinder {

    private Queue<Long> small = new PriorityQueue();
    private Queue<Long> large = new PriorityQueue();
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }
    
    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
