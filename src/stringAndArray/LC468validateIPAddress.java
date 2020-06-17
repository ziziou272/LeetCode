package stringAndArray;

import java.util.HashSet;
import java.util.regex.Pattern;

public class LC468validateIPAddress {
}
class SolutionLC468 {
    public String validIPAddress(String IP) {
        String[] res = new String[]{"IPv4", "IPv6", "Neither"};
        String[] ipv4 = IP.split("\\.");
        String[] ipv6 = IP.split(":");
        if(ipv4.length == 4 && IP.charAt(IP.length() - 1) != '.'){
            if(checkIPv4(ipv4))
                return res[0];
        }
        else if(ipv6.length == 8 && IP.charAt(IP.length() - 1) != ':' ){
            if(checkIPv6(ipv6))
                return res[1];
        }
        return res[2];
    }

    private boolean checkIPv4(String[] ipv4){
        for(String str:ipv4){
            if(str.length() > 3 || str.length() == 0 )
                return false;
            int val = 0;
            for(int i = 0; i < str.length(); i++){
                if(!Character.isDigit(str.charAt(i)))
                    return false;
                if(i != 0 && str.charAt(i - 1) == '0')
                    return false;
                val = val * 10 + str.charAt(i) - '0';
            }
            if(val >= 256)
                return false;
        }
        return true;
    }

    private boolean checkIPv6(String[] ipv6){
        HashSet<Character> set = new HashSet<>();
        String hex = "0123456789abcdefABCDEF";
        for(int i = 0; i < hex.length(); i++){
            set.add(hex.charAt(i));
        }
        for(String str:ipv6){
            if(str.length() > 4 || str.length() == 0)
                return false;
            for(int i = 0; i < str.length(); i++){
                if(!set.contains(str.charAt(i)))
                    return false;
            }
        }
        return true;
    }
}
//regex solution
class SolutionRegex {
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern pattenIPv4 =
            Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern pattenIPv6 =
            Pattern.compile("^(" + chunkIPv6 + ":){7}" + chunkIPv6 + "$");

    public String validIPAddress(String IP) {
        if (pattenIPv4.matcher(IP).matches()) return "IPv4";
        return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
    }
}
/*
regex pattern

("^(" + ipv4Chunk + "\\." + "){3}" + ipv4Chunk +"$")

ipv4Chunk="([0-9]||[1-9][0-9]||[1][0-9][0-9]||[2][0-4][0-9]||25[0-6])"

ipv6 pattern:
("^(" + ipv6Chunk + ":" + "){7}" + ipv6Chunk +"$")

ipv6Chunk="([0-9a-fA-F]){1,4}"
*/
/*

IP


delimiter

ipv4 3 . dot  4 parts
no leading zero and all numbers smaller than 256


ipv6 7: comma   8 parts
hex numbers












*/