package UnionFind;
//todo: 用graph 查环o(n)
public class LC261 {
    public boolean validTree(int n, int[][] edges) {//o(nlgn)
        if(edges == null)
            return false;
        if(n - edges.length != 1)
            return false;
        UnionFind uf = new UnionFind(n);
        //build up the unionFind tree
        for (int[] edge : edges){//o(n)
            int parent = edge[0];
            int child = edge[1];
            if(uf.find(parent,child))//lg(n)
                return false;
            uf.union(parent,child);//lg(n)
        }
        return uf.size == 1;
    }
    class UnionFind{
        int size;
        int [] ids, sz;

        UnionFind(int n){
            this.ids = new int[n];
            this.sz = new int [n];
            size = n;
            for(int i = 0; i < n; i++){
                ids[i] = i;
                sz[i] = 1;
            }
        }

        private int getRoot(int p){
            int temp = p;
            while(ids[p] != p){
                ids[p] = ids[ids[p]];
                p = ids[p];
            }
            ids[temp] = ids[p];
            return ids[temp];
        }

        private boolean find(int p, int q){
            return getRoot(p) == getRoot(q);
        }

        private void union(int p, int q){
            int pRoot = getRoot(p);
            int qRoot = getRoot(q);
            if(sz[pRoot] <= sz[qRoot]){
                sz[qRoot]++;
                ids[pRoot] = ids[qRoot];
                this.size--;
            }
            else
            {
                union(q,p);
            }
        }
    }
}
