package Graph;

public class BellmanFord {

    /**
     *
     * @param edges all edges [from, to, weight]
     * @param start start vertex
     * @param numOfV number of vertices
     */
    public static void mark(int[][] edges, int start, int numOfV){
        int[] distance = new int[numOfV];
        for(int i = 0; i < numOfV; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        //relax edges
        for(int i = 0; i < numOfV - 1; i++){
            for(int[] edge : edges){
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                if(distance[from] != Integer.MAX_VALUE && distance[from] + weight < distance[to])
                    distance[to] = distance[from] + weight;
            }
        }

        //check negative cycle
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if(distance[from] != Integer.MAX_VALUE && distance[from] + weight < distance[to] || distance[from] == Integer.MIN_VALUE)
                distance[to] = Integer.MIN_VALUE;
        }

        System.out.printf("%-10s%-10s\n", "Vertex", "Distance");

        for (int i = 0; i < numOfV; i++) {

            System.out.printf("%-10d%-10d\n", i, distance[i]);

        }
    }

    public static void main(String[] args) {
        //question A
        //SA SC SE SF AB AC BG BH CD CF EF EH FD GI HG IH
        int[][] A = new int[][]{ { 0, 1, 7 }, { 0, 3, 6 }, { 0, 5, 6 }, { 0, 6, 5 }, { 1, 2, 4 }, { 1, 3, -2 },
                { 2, 7, -2 }, { 2, 8, -4 }, { 3, 4, 2 }, { 3, 6, 1 }, { 5, 6, -2 }, { 5, 8, 3 }, { 6, 4, 3 },
                { 7, 9, -1 }, { 8, 7, 1 }, { 9, 8, 1 } };

        mark(A, 0,10);

        //question B
        //SA SG AE BA BC CD DE EB FA FE GF
        int[][] B = { { 0, 1, 10 }, { 0, 7, 8 }, { 1, 5, 2 }, { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 3 }, { 4, 5, -1 },
                { 5, 2, -2 }, { 6, 1, -4 }, { 6, 5, -1 }, { 7, 6, 1 }};
        mark(B, 0,8);

        //question C
        //st sy tx ty tz xt yx yz zs zx
        int[][] C = { { 0, 1, 6 }, { 0, 3, 7 }, { 1, 2, 5 }, { 1, 3, 8 }, { 1, 4, -4 }, { 2, 1, -2 },
                { 3, 2, -3 }, { 3, 4, 9 }, { 4, 0, 2 }, { 4, 2, 7 } };
        mark(C, 0,5);

        //question D
        //sa sc se ab bg cd dc dg ef fe fg hi ij jh
        int[][] D = { { 0, 1, 3 }, { 0, 3, 5 }, { 0, 5, 2 }, { 1, 2, -4 }, { 2, 7, 4 }, { 3, 4, 6 },
                { 4, 3, -3 }, { 4, 7, 8 }, { 5, 6, 3 }, { 6, 5, -6 }, { 6, 7, 7 }, { 8, 9, 2 },
                { 9, 10, 3 }, { 10, 8, -8 } };
        mark(D, 0,11);
    }
}
