package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class LC305Ans {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0 || positions[0] == null || positions[0].length == 0)
            return res;
        UnionFind uf = new UnionFind(m,n);

        for(int[] position: positions) {
            int r = position[0];
            int c = position[1];
            int p = uf.getIndex(r, c);
            uf.addIsland(p);

            List<int[]> neis = getNeighbour(r, c, m, n);
            for (int[] nei : neis) {
                int q = uf.getIndex(nei[0], nei[1]);
                if (uf.isIsland(q) && !uf.find(p, q)) {
                    uf.union(p, q);
                }
            }
            res.add(uf.size);
        }
        return res;

    }

    private List getNeighbour(int r, int c, int m, int n){
        List<int[]>neis = new ArrayList<>();
        if(r - 1 >= 0){int[]one = new int[2];one[0] = r -1;one[1] = c;neis.add(one);}
        if(c - 1 >= 0){int[]one = new int[2];one[0] = r;one[1] = c - 1;neis.add(one);}
        if(r + 1 < m){int[]one = new int[2];one[0] = r + 1;one[1] = c;neis.add(one);}
        if(c + 1 < n){int[]one = new int[2];one[0] = r;one[1] = c + 1;neis.add(one);}
        return neis;
    }

    private class UnionFind{
        public int size, row, col;
        public int [] siz;
        public int [] id;

        public  UnionFind(int row, int col){
            this.size = 0;
            this.row = row;
            this.col = col;
            int len = row * col;
            this.siz = new int[len];
            this.id = new int [len];
            for(int i =0; i< len; i++){
                siz[i] = 1;
                id[i] = -1;
            }
        }

        public int getIndex(int i, int j){
            return i * col + j;
        }

        public void union(int p, int q){
            int rootP = getRoot(p);
            int rootQ = getRoot(q);
            if(siz[rootP] < siz[rootQ])
            {
                union(q, p);
            }
            else{

                id[rootQ] = id[rootP];
                siz [rootP] += siz[rootQ];
                this.size--;
            }
        }

        public void addIsland(int p){
            if(id[p] == -1){
                this.size++;
                id[p] = p;
            }
        }

        public boolean find(int p, int q){//o(logn) 需要找到root
            int rootP = getRoot(p);
            int rootQ = getRoot(q);
            return id[rootP] == id[rootQ];
        }

        public boolean isIsland(int p){
            return id[p] != -1;
        }

        private int getRoot(int p){//??????
            int temp = p;
            while(id[p] != p){
                id[p] = id[id[p]];
                p = id[p];
            }
            id[temp] = p;
            return p;
        }
    }
}
