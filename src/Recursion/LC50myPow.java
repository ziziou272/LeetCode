package Recursion;

public class LC50myPow {
    public static double myPow(double x, int n) {

        return fastPow(x, n);

    }
    private static double fastPow(double x, long n){
        if(x == 1) return 1.0;
        if(x == 0) return 0.0;
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n < 0){
            x = 1 / x;
            return fastPow(x, -n);
        }
        double temp = fastPow(x, n/2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
