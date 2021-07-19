package VMwarePropelOA;

public class ShiftStrings {
    public static void main(String[] args) {
        System.out.println(getShiftedString("abcde",25,12));
        System.out.println(getShiftedString2("abcde",25,12));
    }

    public static String getShiftedString(String s, int leftShifts, int rightShifts){
        int len = s.length();
        leftShifts %= len;
        rightShifts %= len;
        if(leftShifts == rightShifts) return s;
        StringBuilder sb = new StringBuilder();
        if(leftShifts > rightShifts){
            leftShifts -= rightShifts;
            return s.substring(leftShifts, len) + s.substring(0, leftShifts);
        }else{
            rightShifts -= leftShifts;
            //abcde
            //eabcd
            return s.substring(len - rightShifts, len) + s.substring(0, len - rightShifts);
        }
    }

    public static String getShiftedString2(String str, int leftShifts, int rightShifts) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (leftShifts - rightShifts == 0) {
            return str;
        }
        leftShifts = (leftShifts - rightShifts) % str.length();
        return str.substring(leftShifts) + str.substring(0, leftShifts);
    }

}

/*
* abcde
* bcdea
* cdeab
* bcdea
* l:2, r:1
*
* l %= length
* r %= length
* */
