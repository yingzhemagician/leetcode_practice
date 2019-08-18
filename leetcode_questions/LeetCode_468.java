/*
不是什么好题，就是一点点检查
我自己写的方法慢一些
*/

class Solution {
    public String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0) return "Neither";
        
        boolean isIPv4 = false;
        boolean isIPv6 = false;
        
        int i = 0;
        
        for(; i < IP.length(); i++){
            if(IP.charAt(i) == '.'){
                isIPv4 = true;
                break;
            }
            if(IP.charAt(i) == ':'){
                isIPv6 = true;
                break;
            }
        }
        
        if(i == IP.length()) return "Neither";
        
        if(isIPv4) return checkIPv4(IP);
        if(isIPv6) return checkIPv6(IP);
        
        return "Neithrer";
    }
    
    private String checkIPv4(String IP){
        if(IP.charAt(IP.length()-1) == '.') return "Neither";
        String[] arr = IP.split("\\.");
        if(arr.length != 4) return "Neither";
        
        for(String str : arr){
            if(str.length() == 0 || (str.length() > 1 && (str.charAt(0) == '0' || str.charAt(0) == '+' || str.charAt(0) == '-')))
                return "Neither";
            
            try{
                int num = Integer.valueOf(str);
                if(num < 0 || num > 255)
                    return "Neither";
                
            }catch(Exception e){
                return "Neither";
            }
        }
        return "IPv4";
    }
    
    private String checkIPv6(String IP){
        if(IP.charAt(IP.length()-1) == ':') return "Neither";
        String[] arr = IP.split(":");
        System.out.println(arr.length);
        if(arr.length != 8) return "Neither";
        
        for(String str : arr){
            System.out.println(str);
            if(str.length() == 0 || str.length() > 4)
                return "Neither";
            
            for(char c : str.toCharArray()){
                if(c >= '0' && c <= '9') continue;
                else if(c >= 'a' && c <= 'f') continue;
                else if(c >= 'A' && c <= 'F') continue;
                else return "Neither";
            }
        }
        
        return "IPv6";
    }
}


// class Solution {
//     public String validIPAddress(String IP) {
//         if (isValidIPv4(IP)) return Type.IPv4;
//         if (isValidIPv6(IP)) return Type.IPv6;     
//         return Type.Neither;
//     }
    
//     private boolean isValidIPv4(String IP) {
//         if (IP.isEmpty() || !IP.contains(".") || 
//             IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.')
//             return false;
        
//         String[] tokens = IP.split("\\.");
//         if (tokens.length != 4) return false;
        
//         for (String token : tokens) {
//             if (token.isEmpty() || token.length() > 1 && token.charAt(0) == '0') return false;
            
//             int num = 0;
//             for (char c : token.toCharArray()) {
//                 if (c >= '0' && c <= '9') {
//                     num = 10 * num + c - '0';
//                 } else {
//                     return false;
//                 }
                
//                 if (num > 255) return false;
//             }
            
//             if (num < 0 || num > 255) return false;
//         }
        
//         return true;
//     }
    
//     private boolean isValidIPv6(String IP) {
//         if (IP.isEmpty() || !IP.contains(":") || 
//             IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':')
//             return false;
        
//         String[] tokens = IP.split(":");
//         if (tokens.length != 8) return false;
        
//         for (String token : tokens) {
//             if (token.isEmpty() || token.length() > 4) return false;
            
//             for (char c : token.toCharArray()) {
//                 if (c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F')
//                     continue;
                
//                 return false;
//             }
//         }
        
//         return true;
//     }
    
//     private static class Type {
//         public static String IPv4 = "IPv4";
//         public static String IPv6 = "IPv6";
//         public static String Neither = "Neither";
//     }
// }
