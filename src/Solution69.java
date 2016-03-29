/**
 * Created by X on 30/03/2016.
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class Solution69 {
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long low = 1;
        long high = x / 2 + 1;
        while(low <= high) {
            long mid = low + (high - low + 1) / 2;
            if(mid * mid == x) {
                return (int)mid;
            } else if(mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(low * low < x) {
            return (int)low;
        } else {
            return (int)low - 1;
        }
    }

    public static void main(String [] args) {
        System.out.print(mySqrt(1024));
    }
}
