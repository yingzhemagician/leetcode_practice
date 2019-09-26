/*
题目很简单，难的地方就是要分清楚情况，自己的解法空间不错，时间太慢
快的答案是
先封装一个Transaction类
然后先把对象都放进一个数组，然后两个for遍历数组。。。。不太适合作为算法题。。。
*/

class Solution {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;
        String string;
        public Transaction(String csv) {
            String[] parts = csv.split(",");
            this.name = parts[0];
            this.time = Integer.parseInt(parts[1]);
            this.amount = Integer.parseInt(parts[2]);
            this.city = parts[3];
            this.string = csv;
        }
        
        public String toString() { return this.string; }
    }
    
    public List<String> invalidTransactions(String[] transactions) {
        Transaction[] arr = new Transaction[transactions.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = new Transaction(transactions[i]);
        
        List<String> res = new ArrayList<>(); 
        for (int i = 0; i < arr.length; i++)
            if (arr[i].amount > 1000 || !checkValid(arr, i))
                res.add(arr[i].toString());

        return res; 
    }
    
    public boolean checkValid(Transaction[] transactions, int index) {
        Transaction curr = transactions[index];
        for (int i = 0; i < transactions.length; i++) {
            Transaction other = transactions[i];
            if (i != index && curr.name.equals(other.name) && Math.abs(curr.time - other.time) <= 60 && !curr.city.equals(other.city)) {
                return false;
            }
        }
        return true;
    }
}

// class Solution {
//     public List<String> invalidTransactions(String[] transactions) {
//         Set<String> tempRes = new HashSet<>();
//         Map<String, List<String>> map = new HashMap<>();
        
//         for(String trans : transactions){
//             String[] infor = trans.split(",");
//             int amount = Integer.valueOf(infor[2]);
//             if(amount > 1000)
//                 tempRes.add(trans);
            
//             if(!map.containsKey(infor[0])){
//                 List<String> transList = new LinkedList<>();
//                 transList.add(trans);
//                 map.put(infor[0], transList);
//             }
//             else{
//                 List<String> transList = map.get(infor[0]);
//                 int num1 = Integer.valueOf(infor[1]);
                
//                 for(String existTrans : transList){
//                     String[] existInfor = existTrans.split(",");
                    
//                     if(!existInfor[3].equals(infor[3])){
//                         int num2 = Integer.valueOf(existInfor[1]);
//                         if(Math.abs(num1-num2) <= 60){
//                             tempRes.add(trans);
//                             tempRes.add(existTrans);
//                         }
//                     }
//                 }
//                 transList.add(trans);
//             }
//         }
//         return new LinkedList<String>(tempRes);
//     }
// }
