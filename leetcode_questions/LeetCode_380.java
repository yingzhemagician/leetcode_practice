/*
思路是 一个list记录所有数字，一个map记录数字对应的位置
insert
    先看map里有没有，有的话就false；没有的话，就放到list尾，并把index放进map
    
remove
    先看map里有没有，没有的话就false；有的话，通过map得到index，把list中相应index位置的元素改成list的最后一个元素，然后删除最后一个元素，同时将index位置的新元素和这个index再放入map
    
getRandom
    先Random random = new Random();
    然后int index = random.nextInt(list.size());
    再返回该index的数
*/

class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int lastElement = list.get(list.size()-1);
            list.set(index, lastElement);
            list.remove(list.size()-1);
            map.put(lastElement, index);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
