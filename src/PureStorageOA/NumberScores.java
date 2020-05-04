package PureStorageOA;

public class NumberScores {
    public int computerScore(int n){
        if(n < 0)
            return computerScore(n * -1);
        char[] numChar = Integer.toString(n).toCharArray();
        return count7AndEven(numChar) + countConsecutive2s(numChar) + nSquarePoint(numChar) + multiple3(n) + countEven(numChar);
    }

    private int count7AndEven(char[] num){
        int count = 0;
        for(int i = 0; i < num.length; i++){
            if(num[i] == '7')
                count++;
        }
        return count * 5;
    }
    private int countConsecutive2s(char[] num){
        int count = 0;
        for(int i = 0; i < num.length; i++){
            if(i - 1 >= 0 && num[i] == '2' && num[i - 1] =='2'){
                count++;
            }
        }
        return count * 6;
    }
    private int nSquarePoint(char[] num){
        int i = 0;
        int score = 0;
        while(i < num.length){
            int count = 1;
            while(i + 1 < num.length && num[i] - num[i + 1] == 1){
                count++;
                i++;
            }
            score += count * count;
            i++;
        }
        return score;
    }
    private int multiple3(int n){
        if(n % 3 == 0)
            return 4;

        else
            return 0;
    }
    private int countEven(char[] num){
        int count = 0;
        for (char c : num) {
            if ((c - '0') % 2 == 0) {
                count++;
            }
        }
        return count * 3;
    }
    public static void main(String[] args){
        NumberScores test = new NumberScores();
        System.out.println(test.computerScore(22222));
    }
}
