package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class LC305 {//跑不过
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0 || positions[0] == null || positions[0].length == 0)
            return res;
        UnionFind uf = new UnionFind(m,n);

        for(int i = 0 ; i < positions.length; i++){
            int r = positions [i][0];
            int c = positions [i][1];
            int index = uf.getIndex(r, c);
            if(uf.id[index] == -1){
                uf.size++;
                uf.id[index]  = index;
            }
            checkNeighbors(r,c,uf);
            res.add(uf.size);
        }
        return res;
    }

    private void checkNeighbors(int r, int c, UnionFind uf){
        if((r - 1) >= 0 && uf.id[uf.getIndex(r - 1,c)] != -1 && !uf.find(uf.getIndex(r-1,c),uf.getIndex(r,c))){//up
                uf.union(uf.getIndex(r-1, c), uf.getIndex(r,c));
        }
        if((c - 1) >= 0 && uf.id[uf.getIndex(r,c-1)] != -1 &&!uf.find(uf.getIndex(r,c-1),uf.getIndex(r,c))) {//left
                uf.union(uf.getIndex(r, c - 1), uf.getIndex(r,c));
        }
        if((c + 1) < uf.col && uf.id[uf.getIndex(r,c+1)] != -1 &&!uf.find(uf.getIndex(r,c+1),uf.getIndex(r,c))){
                uf.union(uf.getIndex(r, c + 1), uf.getIndex(r,c));
        }
        if((r + 1) < uf.row && uf.id[uf.getIndex(r + 1,c)] != -1&&!uf.find(uf.getIndex(r+1,c),uf.getIndex(r,c))){
                uf.union(uf.getIndex(r + 1, c), uf.getIndex(r,c));
        }
    }

    class UnionFind{
        public int size, row, col;
        int [] id;
        int [] siz;

        UnionFind(int row, int col){
            this.size = 0;
            this.row = row;
            this.col = col;
            int len = row * col;
            this.id = new int[len];
            this.siz = new int[len];
            for(int i = 0; i < len; i++){
                id[i] = -1;
                siz[i] = 1;
            }
        }

        private int getRoot(int p){
            int temp = p;
            while (id[p] != p){
                id[p] = id[id[p]];
                p = id[p];
            }
            id[temp] = p;
            return p;
        }

        private boolean find(int p, int q){
            int rootP = getRoot(p);
            int rootQ = getRoot(q);
            return id[rootP] == id[rootQ];
        }

        private void union(int p, int q){
            int rootP = getRoot(p);
            int rootQ = getRoot(q);
            if(siz[rootP] < siz[rootQ]){
                id[rootP] = id[rootQ];
                siz[rootP] += siz[rootQ];
                this.size--;

            }

            else{
                id[rootQ] = id[rootP];
                siz[rootP] += siz[rootQ];
                this.size--;
            }
        }
        private int getIndex(int i, int j){
            return col * i + j;
        }
    }
}
