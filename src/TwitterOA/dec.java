package TwitterOA;

import java.util.List;

public class dec {
    class Result {

        /*
         * Complete the 'maxHeight' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY tablePositions
         *  2. INTEGER_ARRAY tableHeights
         */

        public int maxHeight(List<Integer> tablePositions, List<Integer> tableHeights) {
            // Write your code here
            //corner case
            if(tablePositions == null || tableHeights == null || tableHeights.size() != tablePositions.size()) return 0;
            int result = 0;
            for(int i = 0; i < tablePositions.size(); i++){
                int curMax = calcuHeight(tablePositions.get(i) - tablePositions.get(i), tableHeights.get(i), tableHeights.get(i - 1));
                result = Math.max(result, curMax);
            }
            return result;
        }
        private int calcuHeight(int distance, int height1, int height2){
            int minH = Math.min(height1, height2);
            int maxH = Math.max(height1, height2);
            if(distance == 0) return 0;
            if(distance == 1) return minH + 1;

            if(minH == maxH){
                int diff = distance % 2 == 0 ? distance /2 : distance / 2 + 1;
                return minH + diff;
            }
            int delta = maxH - minH;
            if(delta < distance){
                distance -= delta;
                minH += delta;
                int diff = distance % 2 == 0 ? distance /2 : distance / 2 + 1;
                return minH + diff;
            }
            return minH + distance;
        }

    }
}
