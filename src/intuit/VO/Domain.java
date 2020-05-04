package intuit.VO;

import java.util.*;

public class Domain {
    public static void main(String[]args){
        subDomainVisits solution = new subDomainVisits();
        String[][] domains = new String[][]{
                {"google.com", "60"},
                {"yahoo.com", "50"},
                {"sports.yahoo.com", "80"},
                {"sports.google.com", "20"},
                {"news.yahoo.com", "80"},
                {"yahoo.com", "200"},
                {"google.com", "60"}
        };
        System.out.println(Arrays.deepToString(solution.subdomainVisits(domains)));
        System.out.println();
        //Q2:
        String[] str1 = new String[]{
                "google.com",
                "yahoo.com",
                "sports.yahoo.com",
                "sports.google.com", "20"
        };
        String[] str2 = new String[]{
                "google.com", "20",
                "yahoo.com",
                "sports.yahoo.com",
                "sports.google.co", "20",
                "yahoo.com"
        };

        longestCommonHistory sol = new longestCommonHistory();
        System.out.println(Arrays.toString(sol.longest(str1, str2)));
        //q3:
        String[] usedId = new String[]{
                "a123",
                "a_yahoo",
                "sports2"
        };
        String[] product_ip = new String[]{
                "water, 192.169.2.3",
                "coke, 123.123",
                "pepsi, 133.345",
                "coffee, 192.169.2.3",
                "coffee, 192.169.2.3",
                "coke, 123.123",
                "coke, 123.123",
                "coke, 123.123",
                "coke, 123.123",
                "coffee, 192.169.2.3",
                "pepsi, 133.345",
                "pepsi, 121.2424",
                "pepsi, 121.2424",
                "coffee, 12.32",
                "coffee, 12.32"
        };
        String[] ip_userId = new String[]{
                "123.123, a123",
                "133.345, a_yahoo",
                "12.32,   sports2",
                "1213.2424,    google2",
                "192.169.2.3,   20a"
        };
        purchaseHistory so = new purchaseHistory();
        so.getPurchaseHistory(usedId, product_ip, ip_userId);
    }
}
class subDomainVisits{
/*
    输入：[
            ["google.com", "60"],
            ["yahoo.com", "50"],
            ["sports.yahoo.com", "80"]
            ]
    输出：[
            ["com", "190"], (60+50+80)
            ["google.com", "60"],
            ["yahoo.com", "130"] (50+80)
            ["sports.yahoo.com", "80"]
            ]
*/

    /** q1:
     * 1.clarify input and output
     * 2.traverse the input and split the website to different domains
     * 3. put domains to hash map key: domain value: visit time
     * 4.return the result
     * time complexity: o(n) if the website's length is constant
     * space complexity: o(n)
     */
    public String[][] subdomainVisits(String[][] cpdomains) {
        //domain, count
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cpdomain: cpdomains){
            String [] domains = cpdomain[0].split("\\.");
            int count = Integer.parseInt(cpdomain[1]);
            StringBuilder sb = new StringBuilder();
            for(int i = domains.length - 1; i >= 0; i--){
                if(i != domains.length - 1)
                    sb.insert(0, ".");
                sb.insert(0, domains[i]);
                String domain = sb.toString();
                if(map.containsKey(domain))
                    map.put(domain, map.get(domain) + count);
                else
                    map.put(domain, count);
            }
        }
        String[][] res = new String[map.size()][2];
        int row = 0;
        for(String key : map.keySet()){
            res[row][0] = key;
            res[row][1] = map.get(key).toString();
            row++;
        }
        return res;
    }
}
/*
 ["3234.html", "xys.html", "7hsaa.html"], // user1
 ["3234.html", ''sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2

      0 1 2
    0 1 0 0
    1 0 0 0
    2 0 1 0
    3 0 0 2
    if(user1[i] == user2[j])
        dp[i][j] = 1 + dp[i - 1] [j - 1]
    else
         dp[i][j] = 0
 */

/**
 * 1.intuitive solution is check all the possible history(subarray)
 * which will cost m^2 * n^2
 * 2.Since this solution has duplicate calcuations,
 * I think I can store the result that I calculated before
 * 3. I think I can use a 2d array to store the result,
 * for example: row is the index of string 1 and col is index of 2
 * 4. during filling out the matrix, we keep a max len
 */
class longestCommonHistory{
    //time complexity:  m * n
    // do we need consider the length of the domains?
    //space complexity:  m * n
    public String[] longest(String[] user1, String[] user2){
        int user1Len = user1.length;
        int user2Len = user2.length;
        int startIndex = 0;
        int len = 0;
        int[][] dp = new int[user1Len][user2Len];
        for(int i = 0; i < user1Len; i++) {
            for (int j = 0; j < user2Len; j++){
                if (user1[i].equals(user2[j])){
                    dp[i][j] = (i - 1 < 0 || j - 1 < 0 ? 1 :
                            dp[i - 1][j - 1] + 1);
                }
                else dp[i][j] = 0;
                if(dp[i][j] > len){
                    len = dp[i][j];
                    startIndex = i - len + 1;
                }
            }
        }
        String[] res = new String[len];
        for(int i = 0; i < len; i++){
            res[i] = user1[startIndex++];
        }
        return res;
    }
}

/** purchased user id;  product name - ip;      ip - user id;
 * "a123";;            "water, 192.169.2.3"     "123.123, a123",
 *1. output List<String> product name, visit time, purchase time
 */
class purchaseHistory{
    //userId, product - ip, ip - userId
    //返回每个网站text 所对应购买数和访问数
    public List<String> getPurchaseHistory(String[] purchasedUser, String[] history, String[] ipAddressUser){
        //result/target: product -  purchase visit
        HashMap<String,int[]> count = new HashMap<>();
        //copy to hashSet
        HashSet<String> purchasedUserId = new HashSet<>(Arrays.asList(purchasedUser));
        //product list<ip>
        HashMap<String, List<String>> productIdMap = new HashMap<>();
        for(String hist : history){
            String[] historyArray = hist.split(",\\s+");
            if(!productIdMap.containsKey(historyArray[0]))
                productIdMap.put(historyArray[0], new ArrayList<>());
            productIdMap.get(historyArray[0]).add(historyArray[1]);
        }
        //ip - used id
        HashMap<String, String> ipUserMap = new HashMap<>();
        for(String ipUser : ipAddressUser){
            String[] ipUserArray = ipUser.split(",\\s+");
            ipUserMap.put(ipUserArray[0], ipUserArray[1]);
        }
        //count
        for(String product : productIdMap.keySet()){
            //   userId-ip
            //purchased
            List<String> ipList = productIdMap.get(product);
            for(String ip : ipList){
                if(purchasedUserId.contains(ipUserMap.get(ip))){
                    if(count.containsKey(product))
                        count.get(product)[0]++;
                    else{
                        count.put(product, new int[2]);
                        count.get(product)[0] = 1;
                    }
                }
                //not purchased
                else {
                    if (count.containsKey(product))
                        count.get(product)[1]++;
                    else {
                        count.put(product, new int[2]);
                        count.get(product)[1] = 1;
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for(String product : count.keySet()){
            res.add(product + ": " + count.get(product)[0] + " " + count.get(product)[1]);
        }
        for(String re: res)
            System.out.println(re);
        return res;
    }
}




















