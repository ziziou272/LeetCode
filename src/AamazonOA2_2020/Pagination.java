package AamazonOA2_2020;

import java.util.*;


public class Pagination {
    public static void main(String[] args) {
        HashMap<String, PairInt> map = new HashMap<>();
        map.put("item1", new PairInt(10, 15));
        map.put("item2", new PairInt(3, 4));
        map.put("item3", new PairInt(17, 8));
        System.out.print(fetchItemsToDisplay(3, map, 1, 0, 2, 1));
    }

    public static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, PairInt> items, int sortParameter,
                                                   int sortOrder, int itemsPerPage, int pageNumber){

        List<String> itemList = new ArrayList<>(items.keySet());
        Comparator<String> comparatorByName = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Comparator<String> comparatorByRelevance = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return items.get(o1).relevance - items.get(o2).relevance;
            }
        };
        Comparator<String> comparatorByPrice = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return items.get(o1).price - items.get(o2).price;
            }
        };

        if(sortParameter == 0){
            if (sortOrder == 0) {
                itemList.sort(comparatorByName);
            } else {
                itemList.sort(comparatorByName.reversed());
            }
        } else if(sortParameter == 1){
            if (sortOrder == 0) {
                itemList.sort(comparatorByRelevance);
            } else {
                itemList.sort(comparatorByRelevance.reversed());
            }
        }else{
            if (sortOrder == 0) {
                itemList.sort(comparatorByPrice);
            } else {
                itemList.sort(comparatorByPrice.reversed());
            }
        }

        List<String> res = new ArrayList<>();
        int startIndex = itemsPerPage *(pageNumber);
        for(; startIndex < startIndex + pageNumber && startIndex < itemList.size(); startIndex++){
            res.add(itemList.get(startIndex));
        }
        return res;
    }

}
class PairInt{
    public int relevance;
    public int price;

    public PairInt(int relevance, int price) {
        this.relevance = relevance;
        this.price = price;
    }

    public PairInt(){

    }
}