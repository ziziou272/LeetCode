package blackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChange {
    private static final int[] CHANGES = {1, 2, 5, 10, 20, 50};
    private static final String[] CHANGES_STRING = {"ONE", "TWO", "FIVE", "TEN", "TWENTY", "FIFTY"};
    private static final String[][] UNIT = {{"Pence", "Pence"}, {"Pound", "Pounds"}};

    public static void main(String[] args) throws IOException {
        calculateChange(15.92, 20);
        calculateChange(25.79, 30);
        calculateChange(200, 220);
        calculateChange(315.23, 359);
        calculateChange(3.58, 21);

    }

    public static void calculateChange(double purchasePrice, double cash) {
        //corner case
        double difference = cash - purchasePrice;
        if(difference < 0){
            System.out.println("ERROR");
            return;
        }
        if(difference == 0){
            System.out.println("Zero");
            return;
        }

        //divide change to pound and pence eg.7.56 -> 7 pound and 56 pence
        int changeOfPound = (int) difference;
        int changeOfPence = (int) ((difference - changeOfPound) * 100);

        //calculate result separately
        String poundString = calculate(changeOfPound, 1);
        String penceString = calculate(changeOfPence, 0);

        //print result
        System.out.println(poundString + (penceString.equals("") ? "" : (", " + penceString)));

    }

    private static String calculate(int amount, int index){
        if(amount == 0) return "";
        StringBuilder sb = new StringBuilder();

        for(int i = CHANGES.length - 1; i >= 0; i--){
            if(amount >= CHANGES[i]){
                int num = amount / CHANGES[i];
                //check plural
                String unitString = CHANGES[i] == 1 ? UNIT[index][0] : UNIT[index][1];
                while(num-- > 0){
                    sb.append(CHANGES_STRING[i]).append(" ").append(unitString).append(", ");
                }
                amount %= CHANGES[i];
                if(amount == 0) break;
            }
        }
        //remove trailing semicoma and space
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
