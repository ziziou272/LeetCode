package blackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Problem3 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

    }

    private static class Transaction {
        private String transactionType;
        private String name;
        private String assetType;
        private int share;

        public Transaction(String transactionType, String name, String assetType, int share) {
            this.transactionType = transactionType;
            this.name = name;
            this.assetType = assetType;
            this.share = share;
        }
    }

    public static void matchBenchmark(String input) {
        // Access your code here. Feel free to create other classes as required

        // split the portfolio and benchmark
        String[] inputArr = input.split(":");
        String portfolio = inputArr[0];
        String benchmark = inputArr[1];

        // init map and put portfolio holdings into map
        Map<String, Integer> mapStock = new HashMap<>();
        Map<String, Integer> mapHolding = new HashMap<>();
        buildMap(portfolio, mapStock, mapHolding);

        // traverse benchmark holdings, find the diff with map, and add to res
        List<Transaction> res = new ArrayList<>();
        comapareDiff(benchmark, mapStock, mapHolding, res);

        // sort the res by alphabetical order based on the names; if both bonds and stock are present for an asset, list bonds first
        Collections.sort(res, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                if (!t1.name.equals(t2.name)) {
                    return t1.name.compareTo(t2.name);
                }
                else {
                    if (t1.assetType.equals("BOND")) return -1;
                    else return 1;
                }
            }
        });

        // print out the result
        for (Transaction t: res) {
            System.out.println(t.transactionType + "," + t.name + "," + t.assetType + "," + t.share);
        }
    }

    private static void comapareDiff(String benchmark, Map<String, Integer> mapStock, Map<String, Integer> mapHolding, List<Transaction> res) {
        // traverse the benchmark
        int s = 0;
        int e = 0;
        while (s < benchmark.length()) {
            // get the name
            String name = "";
            while (e < benchmark.length() && benchmark.charAt(e) != ',') e++;
            name = benchmark.substring(s, e);
            e = e + 1;
            s = e;

            // get the asset type
            String assetType = "";
            while (e < benchmark.length() && benchmark.charAt(e) != ',') e++;
            assetType = benchmark.substring(s, e);
            e = e + 1;
            s = e;

            // get the share
            int share = 0;
            while (e < benchmark.length() && benchmark.charAt(e) != '|') e++;
            share = Integer.parseInt(benchmark.substring(s, e));

            // compare with map
            String transactionType = "";
            int transactionShare = 0;
            if (assetType.equals("STOCK")) {
                int before = mapStock.containsKey(name) ? mapStock.get(name) : 0;
                int after = share;
                transactionType = before > after ? "SELL" : "BUY";
                transactionShare = Math.abs(before - after);
                if (transactionShare != 0) {
                    Transaction transaction = new Transaction(transactionType, name, assetType, transactionShare);
                    res.add(transaction);
                }
            }
            else if (assetType.equals("BOND")) {
                int before = mapHolding.containsKey(name) ? mapHolding.get(name) : 0;
                int after = share;
                transactionType = before > after ? "SELL" : "BUY";
                transactionShare = Math.abs(before - after);
                if (transactionShare != 0) {
                    Transaction transaction = new Transaction(transactionType, name, assetType, transactionShare);
                    res.add(transaction);
                }
            }

            // update s and e
            e = e + 1;
            s = e;
        }
    }

    private static void buildMap(String portfolio, Map<String, Integer> mapStock, Map<String, Integer> mapHolding) {
        // traverse the portfolio
        int s = 0;
        int e = 0;
        while (s < portfolio.length()) {
            // get the name
            String name = "";
            while (e < portfolio.length() && portfolio.charAt(e) != ',') e++;
            name = portfolio.substring(s, e);
            e = e + 1;
            s = e;

            // get the asset type
            String assetType = "";
            while (e < portfolio.length() && portfolio.charAt(e) != ',') e++;
            assetType = portfolio.substring(s, e);
            e = e + 1;
            s = e;

            // get the share
            int share = 0;
            while (e < portfolio.length() && portfolio.charAt(e) != '|') e++;
            share = Integer.parseInt(portfolio.substring(s, e));

            // add to map
            if (assetType.equals("STOCK")) mapStock.put(name, share);
            else mapHolding.put(name, share);

            // update s and e
            e = e + 1;
            s = e;
        }
    }

}