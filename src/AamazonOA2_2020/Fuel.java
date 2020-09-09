package AamazonOA2_2020;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Fuel {
    public static int chooseFlask(int numOrders, List<Integer> requirements, int flaskTypes,
                    int totalMarks, List<PairInt> markings) {

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (PairInt key: markings) {
            map.putIfAbsent(key.first, new TreeSet<>());
            map.get(key.first).add(key.second);
        }

        int id = Integer.MAX_VALUE;
        int minCost = Integer.MAX_VALUE;
        Outer:
        for (int typeId: map.keySet()) {
            TreeSet<Integer> set =map.get(typeId);
            int tempWaste = 0;
            for (int require: requirements) {
                Integer mark = set.ceiling(require);
                if (mark != null) tempWaste += mark - require;
                else continue Outer;
            }
            if (tempWaste < minCost) {
                id = typeId;
                minCost = tempWaste;
            }
        }
        return id == Integer.MAX_VALUE ? -1 : id;
    }
    class PairInt{
        int first, second;
    }
}
