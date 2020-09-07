package AamazonOA2_2020;

import java.util.*;

public class ClosetCity {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList( "c1", "c2", "c3" );
        List<Integer> xCoordinates = Arrays.asList(3, 2, 1);
        List<Integer> yCoordinates = Arrays.asList(3, 2, 3);
        List<String> queries = Arrays.asList( "c1", "c2", "c3" );
        System.out.println("Test: ");
        System.out.println(closetStraightCity(3, cities, xCoordinates, yCoordinates, 3, queries));
        //test 2
        List<String> cities2 = Arrays.asList( "c1", "c2", "c3", "c4", "c5");
        List<Integer> xCoordinates2 = Arrays.asList(1, 2, 3,4,5);
        List<Integer> yCoordinates2 = Arrays.asList(1, 2, 3,4,5);
        List<String> queries2 = Arrays.asList( "c1", "c2", "c3", "c4", "c5");
        System.out.println("Test: ");
        System.out.println(closetStraightCity(5, cities2, xCoordinates2, yCoordinates2, 5, queries2));
        //test 3
        List<String> cities3 = Arrays.asList( "fas", "big", "xyz");
        List<Integer> xCoordinates3 = Arrays.asList(23, 23, 23);
        List<Integer> yCoordinates3 = Arrays.asList(1, 10, 20);
        List<String> queries3 = Arrays.asList( "fas", "big", "xyz");
        System.out.println("Test: ");
        System.out.println(closetStraightCity(3, cities3, xCoordinates3, yCoordinates3, 3, queries3));
        //test 4
        List<String> cities4 = Arrays.asList( "london", "warsaw", "hackerLand");
        List<Integer> xCoordinates4 = Arrays.asList(1, 10, 20);
        List<Integer> yCoordinates4 = Arrays.asList(1, 10, 10);
        List<String> queries4 = Arrays.asList( "london", "warsaw", "hackerLand");
        System.out.println("Test: ");
        System.out.println(closetStraightCity(3, cities4, xCoordinates4, yCoordinates4, 3, queries4));
        //test 5
        List<String> cities5 = Arrays.asList( "monterey","m3n","mont","los gatos","los altos","san marino","san mateo","san francisco");
        List<Integer> xCoordinates5 = Arrays.asList(3250,7000,7000,2000,4050,1000,2000,4050);
        List<Integer> yCoordinates5 = Arrays.asList(2500,19250,3000,10000,2500,2500,10000,3000);
        List<String> queries5 = Arrays.asList( "monterey", "mont","los gatos","los altos","san marino","san mateo","san francisco");
        System.out.println("Test: ");
        System.out.println(closetStraightCity(8, cities5, xCoordinates5, yCoordinates5, 7, queries5));

    }

    public static List<String> closetStraightCity(int numOfCities, List<String> cities, List<Integer> xCoordinates,
                                    List<Integer> yCoordinates, int numOfQueries, List<String> queries){
        HashMap<String, int[]> cityCoordinateMap = new HashMap<>();
        // x -> TreeMap<y, city>
        HashMap<Integer, TreeMap<Integer, String>> xCoordinateMap = new HashMap<>();
        HashMap<Integer, TreeMap<Integer, String>> yCoordinateMap = new HashMap<>();
        for(int i = 0; i < numOfCities; i++){
            int x = xCoordinates.get(i);
            int y = yCoordinates.get(i);
            String city = cities.get(i);
            cityCoordinateMap.put(city, new int[]{x, y});
            xCoordinateMap.putIfAbsent(x, new TreeMap<>());
            xCoordinateMap.get(x).put(y, city);
            yCoordinateMap.putIfAbsent(y, new TreeMap<>());
            yCoordinateMap.get(y).put(x, city);
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < numOfCities; i++) res.add("None");
        for (int i = 0; i < numOfQueries; i++){
            String query = queries.get(i);
            int x = cityCoordinateMap.get(query)[0];
            int y = cityCoordinateMap.get(query)[1];
            TreeMap<Integer, String> yCoordinateTreeMap = xCoordinateMap.getOrDefault(x, new TreeMap<>());
            TreeMap<Integer, String> xCoordinateTreeMap = yCoordinateMap.getOrDefault(y, new TreeMap<>());
            int minDifference = Integer.MAX_VALUE;
            //get the greatest value that smaller than y
            Integer ys = yCoordinateTreeMap.lowerKey(y);
            //get the smallest value that greater than y
            Integer yg = yCoordinateTreeMap.higherKey(y);
            Integer xs = xCoordinateTreeMap.lowerKey(x);
            Integer xg = xCoordinateTreeMap.higherKey(x);
            minDifference = updateClosetCity(y, ys, yCoordinateTreeMap, minDifference, i, res);
            minDifference = updateClosetCity(y, yg, yCoordinateTreeMap, minDifference, i, res);
            minDifference = updateClosetCity(x, xs, xCoordinateTreeMap, minDifference, i, res);
            minDifference = updateClosetCity(x, xg, xCoordinateTreeMap, minDifference, i, res);
        }
        return res;
    }

    private static int updateClosetCity(Integer coordinate, Integer otherCoordinate, TreeMap<Integer, String> treeMap, int min, int i, List<String> res){
        if(otherCoordinate != null ){
            String city = res.get(i);
            String curCity = treeMap.get(otherCoordinate);
            int difference = Math.abs(coordinate - otherCoordinate);
            if((difference == min && city.compareTo(curCity) > 0) || difference < min){
                res.set(i, curCity);
                min = difference;
            }
        }
        return min;
    }

    //大弓
    private static List<String> closestStraightCity2(int numOfCities, List<String> cities,
                                                    List<Integer> xCoordinates,
                                                    List<Integer> yCoordinates,
                                                    int numOfQueries,
                                                    List<String> queries) {

        Map<String, Integer> name = new HashMap<>();
        Map<Integer, List<Integer>> xx = new HashMap<>();
        Map<Integer, List<Integer>> yy = new HashMap<>();
        for (int i = 0; i < cities.size(); i++) {
            name.put(cities.get(i), i);
            int x = xCoordinates.get(i);
            int y = yCoordinates.get(i);
            if (xx.get(x) == null) {
                xx.put(x, new LinkedList<>());
            }
            xx.get(x).add(i);
            if (yy.get(y) == null) {
                yy.put(y, new LinkedList<>());
            }
            yy.get(y).add(i);
        }
        List<String> result = new LinkedList<>();
        for (String queryName : queries) {
            int iii = name.getOrDefault(queryName, -1);
            if (iii == -1) {
                result.add("NONE");
                continue;
            }
            int x = xCoordinates.get(iii);
            int y = yCoordinates.get(iii);
            String r = "NONE";
            int distance = Integer.MAX_VALUE;
            for (int m : xx.getOrDefault(x, new LinkedList<>())) {
                if (m == iii) {
                    continue;
                }
                int delta = Math.abs(yCoordinates.get(m) - yCoordinates.get(iii));
                if (delta < distance) {
                    r = cities.get(m);
                    distance = delta;
                } else if (delta == distance) {
                    if (cities.get(m).compareTo(r) < 0) {
                        r = cities.get(m);
                    }
                }
            }
            for (int m : yy.getOrDefault(y, new LinkedList<>())) {
                if (m == iii) {
                    continue;
                }
                int delta = Math.abs(xCoordinates.get(m) - xCoordinates.get(iii));
                if (delta < distance) {
                    r = cities.get(m);
                    distance = delta;
                } else if (delta == distance) {
                    if (cities.get(m).compareTo(r) < 0) {
                        r = cities.get(m);
                    }
                }
            }
            result.add(r);
        }
        return result;
    }
}

