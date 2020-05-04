package UnionFind;

import java.util.HashMap;
import java.util.List;

public class LC399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double [] res = new double[queries.size()];
        if(equations == null || equations.size() == 0 || equations.get(0) == null || equations.get(0).size() == 0)
        {
            for(int i = 0; i < queries.size(); i++)
                res[0] = -1.0;
            return res;
        }
        HashMap<String,Vertex> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String idP = equations.get(i).get(0);
            String idQ = equations.get(i).get(1);
            if(!map.containsKey(idP))
                map.put(idP,new Vertex(idP));
            if(!map.containsKey(idQ))
                map.put(idQ,new Vertex(idQ));
            double val = values[i];
            if(!find(map.get(idP), map.get(idQ))){
                union(map.get(idP), map.get(idQ), val);
            }
        }

        for(int i = 0; i < queries.size(); i++){
            String p = queries.get(i).get(0);
            String q = queries.get(i).get(1);
            if(!map.containsKey(p) || !map.containsKey(q)){
                res[i] = -1.0;
            }
            else {
                Vertex vp = map.get(p);
                Vertex vq = map.get(q);
                if(find(vp,vq))
                    res[i] = getValue(vp, vq);
                else {
                    res[i] = -1.0;
                }
            }
        }
        return res;
    }
    class Vertex{
        String id;
        // val = parent/this
        double val;
        Vertex parent;
        int size;
        //todo : constructor
        Vertex(String id){
            this.id = id;
            this.parent = this;
            this.size = 1;
            this.val = 1.0;
        }

    }
        public Vertex getRoot(Vertex p){
            Vertex cur = p;
            double d = 1.0;
            while(cur != cur.parent){
                cur.val *= cur.parent.val;
                d *= cur.val;
                cur.parent = cur.parent.parent;
                cur = cur.parent;
            }
            p.parent = cur;
            p.val = d;
            return cur;
        }

        public boolean find(Vertex p, Vertex q){
            return getRoot(p) == getRoot(q);
        }

        public void union(Vertex p, Vertex q, double d){
            Vertex rootP = getRoot(p);
            Vertex rootQ = getRoot(q);
            if(rootP.size >= rootQ.size){
                rootQ.parent = rootP;
                rootQ.val = d * p.val / q.val;
                rootP.size += rootQ.size;
            }
            else {
                union(q,p,1/d);
            }
        }

        public double getValue(Vertex p, Vertex q){
            return q.val / p.val;
        }
}
