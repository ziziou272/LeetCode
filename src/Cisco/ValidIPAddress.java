package Cisco;

public class ValidIPAddress {
    public String validIPAddress(String IP) {
        String[] ipv4 = IP.split("\\.",-1);

        if(IP.chars().filter(ch -> ch == '.').count() == 3){
            for(String s : ipv4) {
                if(isIPv4(s)) continue;
                else return "Neither";
            }
            return "IPv4";
        }

        return "Neither";
    }

    public boolean isIPv4 (String s){
        try{
            return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
        } catch (NumberFormatException e){return false;}
    }

    public static void main(String[] args) {

    }
}
