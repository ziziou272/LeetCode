package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class LC200unionFind {
    private class UnionFind{
        int size, row, col;
        int len;
        int[]ids, sizes;
        UnionFind(int size, int row, int col){
            this.size = size;
            this.row = row;
            this.col = col;
            this.len = col * row;
            ids = new int[len];
            sizes = new int[len];
            for(int i = 0; i < len; i++){
                ids[i] = -1;
                sizes[i] = 0;
            }
        }

        public int getRoot(int index){
            int cur = index;
            while(ids[cur] != cur){
                ids[cur] = ids[ids[cur]];
                cur = ids[cur];
            }
            ids[index] = cur;
            return cur;
        }

        public boolean find(int a, int target){
            int rootA = getRoot(a);
            int rootTarget = getRoot(target);
            return rootA == rootTarget;
        }

        public int getIndex(int x, int y){
            return x * col + y;
        }

        public void union(int a, int b){
            int rootA = getRoot(a);
            int rootB = getRoot(b);
            if(sizes[rootA] > sizes[rootB]){
                ids[rootB] = rootB;
                sizes[rootB] += sizes[rootA];
                this.size--;
            }
            else{
                ids[rootA] = rootB;
                sizes[rootA] += sizes[rootB];
                this.size--;
            }
        }

        public void addIsland(int index){
            sizes[index] += 1;
            ids[index] = index;
            this.size++;
        }
        public boolean isIsland(int index){
            return ids[index] != -1;
        }
    }

    public int numIslands(char[][] grid) {
        //todo: cc
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(0, row, col);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int curIndex = uf.getIndex(i, j);
                if(grid[i][j] == '1'){
                    uf.addIsland(curIndex);
                }
                else{continue;}
                List<int []> toCheck = new ArrayList<>();
                toCheck.add(new int[]{0, -1});
                toCheck.add(new int[]{-1, 0});

                for(int k =0; k < 2; k ++){//check up and left
                    int x = i + toCheck.get(k)[0];
                    int y = j + toCheck.get(k)[1];
                    int index = uf.getIndex(x, y);
                    if(x >= 0 && y >= 0 && uf.isIsland(index) && !uf.find(curIndex, index)){//is island
                        uf.union(curIndex, index);
                    }
                }

            }
        }
        return uf.size;
    }
}
