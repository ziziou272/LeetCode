package UnionFind;

import java.util.*;

public class LC721dfs {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //cc
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, List<String>> neis = new HashMap<>();// email to neis

        //build graph
        for(List<String> account : accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                String email = account.get(i);
                emailToName.put(email, name);
                if(!neis.containsKey(email)){
                    neis.put(email, new ArrayList<>());
                }
                if(i == 1) continue;
                String prevEmail = account.get(i - 1);
                neis.get(email).add(prevEmail);
                neis.get(prevEmail).add(email);
            }
        }
        List<List<String>> res = new ArrayList<>();
        //traverse dfs
        HashSet<String> visited = new HashSet<>();
        for(String email : neis.keySet()){
            if(!visited.contains(email)){
                List<String> component = new LinkedList<>();
                visited.add(email);
                //add neis to visited and list
                dfs(email,visited,component,neis);
                //
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                res.add(component);
            }
        }
        return res;
    }

    private void dfs(String email, HashSet<String> visited, List<String> component, HashMap<String,List<String>> neis){
        component.add(email);
        for(String nei : neis.get(email)){
            if(!visited.contains(nei)){
                visited.add(nei);
                dfs(nei, visited, component, neis);
            }
        }
    }
}
