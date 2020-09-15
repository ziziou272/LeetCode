package stringAndArray;

public class LC67AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int lenA = a.length(), lenB = b.length();
        int indexA = lenA - 1, indexB = lenB - 1;
        int carry = 0;
        while(indexA >= 0 || indexB >= 0){
            int valA = indexA < 0 ? 0 : a.charAt(indexA--) - '0';
            int valB = indexB < 0 ? 0 : b.charAt(indexB--) - '0';
            int sum = valA + valB + carry;
            carry = sum / 2;
            int val = sum % 2;
            res.append(val);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
