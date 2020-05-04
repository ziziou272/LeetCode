package WayFair;

import java.util.HashMap;

/**
 * 1.add_product(int id)，功能就是给一个product id，将其加入到仓库中。
 * 2.ship_order(int[] ids)，功能是给一系列product id，判断仓库中的存货是否足够，返回一个boolean。
 * 可以就发货并更新warehouse
 * 这里需要注意的是ids中id可能重复，我就是一开始没注意到，结果错了。
 * ship_order which takes in an array of product_id as input, and return whether or not we are able to ship out all the products in the array.
 * （2）removeProduct 就是给一个id array，每次对相应的product number 减一，如果number < 0 了就return false.
 * （3）inverseRemoveProduct 就是给一个id array 每次相应的product number 加一，比上一个function还简单。
 * （4）liquidateProduct就是给一个id array，删除相应product的所有number，但是注意id array里面可能有duplicate，
 *  用一个hashSet去除duplicate就行。
 * 要求ship_product时按照FIFO的顺序；实现也没什么特殊的，hashmap里的value改成queue类型就ok
 * 口头讲了一下怎么样实现能够让同类产品，先进来的先出去，就是一个first in first out的queue，发货的时候要如果有人退货的话怎么样把退回来的货也考虑在FIFO中
 * 3.return_order 就是退单
 * 4. 删除某个product
 * 口头讲了一下怎么样实现能够让同类产品，先进来的先出去，就是一个first in first out的queue，
 * 发货的时候要如果有人退货的话怎么样把退回来的货也考虑在FIFO中
 */
public class WareHouseSolution {
    public static void main(String[] args){

    }

    class WareHouse{
        //fields
        private HashMap<Integer, Integer> productCount;
        //todo: constructor
        public WareHouse(){
            this.productCount = new HashMap<>();
        }

        /**
         * add product
         * @param id
         * @return product count
         */
        public int addProduct(int id){
            if(!productCount.containsKey(id))
                productCount.put(id, 1);
            else
                productCount.put(id, productCount.get(id) + 1);
            return productCount.get(id);
        }
        /**
         * ship order
         * @param ids
         * @return if have all in stock
         */
        public boolean shipOrder(int[] ids){
            //build HashMap
            HashMap<Integer, Integer> orderCountMap = new HashMap<>();
            for(int id : ids){
                addProduct(id, orderCountMap);
            }
            //check if available
            for(int id : orderCountMap.keySet()){
                int requestQuantity = orderCountMap.get(id);
                if(requestQuantity > productCount.get(id)){
                    return false;
                }
            }
            //
            for (int id : orderCountMap.keySet()){
                int requestQuantity = orderCountMap.get(id);
                productCount.put(id, productCount.get(id) - requestQuantity);
            }
            return true;
        }

        public int addProduct(int id, HashMap<Integer, Integer> map){
            if(!map.containsKey(id))
                map.put(id, 1);
            else
                map.put(id, map.get(id) + 1);
            return map.get(id);
        }

        /**
         * inverse/return order
         * @param ids
         */
        public void inverseOrder(int[] ids){
            for (int id : ids){
                addProduct(id);
            }
        }
    }

}

