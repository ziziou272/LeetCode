package UnionFind;

import java.util.*;

public class LC721UnionFind {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        UnionFind uf = new UnionFind(accounts.size());

        HashMap<String, Integer> emailToId = new HashMap<>();
        HashMap<Integer,List<String>> idToEmail = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            uf.addAccount(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email, i);
                }
                else {
                    int id = emailToId.get(email);
                    uf.union(id, i);
                }
            }
        }
        for(String email : emailToId.keySet()){
            int id = emailToId.get(email);
            int rootId = uf.getRoot(id);
            if(idToEmail.containsKey(rootId))
                idToEmail.get(rootId).add(email);
            else{
                idToEmail.put(rootId, new LinkedList<>());
                idToEmail.get(rootId).add(email);
            }
        }
        for(int id : idToEmail.keySet()){
            Collections.sort(idToEmail.get(id));
            idToEmail.get(id).add(0, accounts.get(id).get(0));
            res.add(idToEmail.get(id));
        }
        return res;
    }
    private class UnionFind{
        int len;
        int[] ids;
        int[] sizs;
        UnionFind(int len){
            this.len = len;
            ids = new int[len];
            sizs = new int[len];
        }
        public int getRoot(int id){
            int cur = id;
            while(ids[cur] != cur){
                ids[cur] = ids[ids[cur]];
                cur = ids[cur];
            }
            ids[id] = cur;
            return cur;
        }

        public boolean find(int a, int b){
            return getRoot(a) == getRoot(b);
        }

        public void union(int a, int b) {
            int rootA = getRoot(a);
            int rootB = getRoot(b);
            if (sizs[rootA] > sizs[rootB]) {
                ids[rootB] = rootA;
                sizs[rootA] += sizs[rootB];

            } else {
                ids[rootA] = rootB;
                sizs[rootB] += sizs[rootB];
            }
        }

        public void addAccount(int id){
            ids[id] = id;
            sizs[id]++;
        }
    }
}
