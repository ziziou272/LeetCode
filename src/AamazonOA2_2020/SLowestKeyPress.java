package AamazonOA2_2020;

public class SLowestKeyPress {
    public static void main(String[] args) {
        System.out.println(slowestKey(new int[][]{
                {0, 2},
                {1, 5},
                {0, 9},
                {2, 15}
        }));
    }

    public static char slowestKey(int[][] keyTimes){
        int max = 0;
        int charIndex = -1;
        for(int i = 0; i < keyTimes.length; i++){
            int prev = i == 0 ? 0 : keyTimes[i - 1][1];
            int duration = keyTimes[i][1] - prev;
            if(duration > max){
                max = duration;
                charIndex = keyTimes[i][0];
            }
        }
        return (char)(charIndex + 'a');
    }
}
