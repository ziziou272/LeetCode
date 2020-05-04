package WayFair;

import java.util.HashMap;

/**
 * technical part: 广告推广ood问题，很简单
 * 第一题就是给了一个公式，然写一个函数计算结果waybid；
 * 第二题用hash保存每个customer用公式算出来的waybid，
 * 第三题每个customer在每个platform上waybid计算方式不同，实现这个功能，就是hash套hash
 */
public class AD {

}
class Bid {
    public HashMap<Integer, Double> customerToBidMap;
    public HashMap<Integer, Customer> idToCus;

    public Bid(){
        customerToBidMap = new HashMap<>();
        idToCus = new HashMap<>();
    }

    public double calculateWayBid(double a, double b){
        if(a <= 0 || b <= 0)
            throw new IllegalArgumentException();
        return a * b * 0.7;
    }
    public void storeWayBid(double a, double b, int customerId){
        double res = calculateWayBid(a, b);
        customerToBidMap.put(customerId, res);
    }
    public void storeWebPrice(double price, int id, String web){
        Customer cur = idToCus.get(id);
        cur.priceMap.put(web, price);
    }
}

class Customer{
    public int id;
    //website to bid price
    public HashMap<String, Double> priceMap;

    public Customer(int id){
        this.id = id;
        priceMap = new HashMap<>();
    }
}
