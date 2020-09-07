package AamazonOA2_2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//passed
public class Debt {


    public static void main(String[] args) {
        List<debtRecord> records = new ArrayList<>();
        records.add(new debtRecord("Alex", "Blake", 2));
        records.add(new debtRecord("Blake", "Alex", 2));
        records.add(new debtRecord("Casey", "Alex", 5));
        records.add(new debtRecord("Blake", "Casey", 7));
        records.add(new debtRecord("Alex", "Blake", 4));
        records.add(new debtRecord("Alex", "Casey", 4));
        System.out.println(minimumDebtMembers(records));
        List<debtRecord> records2 = new ArrayList<>();
        records.add(new debtRecord("Alex", "Blake", 2));
        records.add(new debtRecord("Blake", "Alex", 2));
        System.out.println(minimumDebtMembers(records2));
    }

    public static List<String> minimumDebtMembers(List<debtRecord> records){
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(debtRecord record : records){
            String borrower = record.borrower;
            String lender = record.lender;
            int amount = record.amount;
            map.put(borrower, map.getOrDefault(borrower, 0) - amount);
            map.put(lender, map.getOrDefault(lender, 0) + amount);
        }
        int min = 0;
        for(String person : map.keySet()){
            int amount = map.get(person);
            if(amount < min){
                res.clear();
                res.add(person);
                min = amount;
            }else if(amount == min && amount < 0){
                res.add(person);
            }
        }
        if(res.size() == 0){
            res.add("Nobody has a negative balance");
        }
        return res;
    }

   static class debtRecord{
        String borrower = "";
        String lender = "";
        int amount = 0;
        debtRecord()
        {
            // empty constructor
        }
        debtRecord(String borrower, String lender, int amount)
        {
            this.borrower = borrower;
            this.lender = lender;
            this.amount = amount;
        }
    }
}
 class Teat3 {
    //借钱那题
    List<String> getSNB(int numRows, int numCols, List<debtRecord> debts) {
        Map<String, Integer> nameToBalance = new HashMap<>();
        Map<Integer, List<String>> balanceToName = new HashMap<>();
        int minDebt = 0;
        for (debtRecord record : debts) {
            String borrower = record.borrower;
            String lender = record.lender;
            int amount = record.amount;
            nameToBalance.put(borrower, nameToBalance.getOrDefault(borrower, 0) - amount);
            nameToBalance.put(lender, nameToBalance.getOrDefault(lender, 0) + amount);
        }
        for (Map.Entry<String, Integer> entry : nameToBalance.entrySet()) {
            String name = entry.getKey();
            int balance = entry.getValue();
            if (!balanceToName.containsKey(balance)) {
                balanceToName.put(balance, new ArrayList<>());
            } else {
                balanceToName.get(balance).add(name);
            }
            minDebt = Math.min(minDebt, balance);
        }
        if (minDebt < 0) {
            return balanceToName.get(minDebt);
        } else {
            List<String> res = new ArrayList<>();
            res.add("Nobody has a negative balance");
            return res;
        }
    }
}
class debtRecord {
    String borrower = "";
    String lender = "";
    int amount = 0;
    debtRecord() {

    }
    debtRecord(String borrower, String lender, int amount) {
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
    }
}
