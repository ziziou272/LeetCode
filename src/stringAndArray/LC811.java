package stringAndArray;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class LC811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if(cpdomains == null) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains){
            //split count with domain
            String[] cpDomainSplit = cpdomain.split("\\s+");
            int count = Integer.parseInt(cpDomainSplit[0]);
            String[] domains = cpDomainSplit[1].split("\\.");
            StringBuilder domainBuilder = new StringBuilder();
            for(int i = domains.length - 1; i >= 0; i--){
                if(i != domains.length - 1)
                    domainBuilder.insert(0, ".");
                domainBuilder.insert(0, domains[i]);
                String curDomain = domainBuilder.toString();
                if(!map.containsKey(curDomain))
                    map.put(curDomain, count);
                else
                    map.put(curDomain, map.get(curDomain) + count);
            }
        }
        for(String domain : map.keySet()){
            res.add(map.get(domain) + " " + domain);
        }
        return res;
    }
    public static void main(String[] args){
        String c = "";
        String a = "99001 discuss.leetcode.com";
        String[] aPrime = a.split("\\s+");
        String[] domain = aPrime[1].split("\\.");
        System.out.println(aPrime);
    }
}

/*Input:
     ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
     Output:
     ["901 mail.com",
     "50 yahoo.com",
     "900 google.mail.com",
     "5 wiki.org","5 org",
     "1 intel.mail.com",
     "951 com"]*/
class solution811{
    public List<String> subdomainVisits(String[] cpdomains) {
        //todo: corner case
        HashMap<String, Integer> map = new HashMap<>();
        for(String domains : cpdomains){
            String[] domainArray = domains.split("\\s+\\.");
            int count = Integer.parseInt(domainArray[0]);
            StringBuilder sb = new StringBuilder();
            for(int i = domainArray.length - 1; i > 0; i--){
                if(i != domainArray.length - 1)
                    sb.insert(0, ".");
                sb.insert(0, domainArray[i]);
                String domain = sb.toString();
                if(map.containsKey(domain))
                    map.put(domain, map.get(domain) + count);
                else
                    map.put(domain, count);
            }
        }
        List<String> res = new ArrayList<>();
        for(String key : map.keySet()){
           res.add(map.get(key) + " " + key);
        }
        return res;
    }
}
