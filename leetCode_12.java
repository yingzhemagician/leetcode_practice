public class leetCode_12 {
    public String intToRoman(int num) {

        int[] values = {1000,500,100,50,10,5,1};
        String[] roman = {"M","D","C","L","X","V","I"};

        String res = new String();

        for(int i = 0; i < 7; i = i + 2){
            int digit = num/values[i];

            if(digit < 4)
                for(int j = 1; j <= digit; j++)
                    res += roman[i];
            else if(digit == 4)
                res += roman[i] + roman[i - 1];
            else if(digit > 4 && digit < 9){
                res += roman[i - 1];
                for(int j = 6; j <= digit; j++)
                    res += roman[i];
            }
            else if(digit == 9)
                res += roman[i] + roman[i - 2];

            num = num % values[i];
        }

        return res;
    }
}
