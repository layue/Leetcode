/**
 * Created by X on 28/03/2016.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */
public class Solution38 {
    public static String countAndSay(int n) {
        String num = "1";

        for(int i = 2; i <= n; i ++) {
            num = say(num);
        }

        return num;
    }

    public static String say(String say) {
        String res = "";

        for(int i = 0; i < say.length();) {
            int count = 1;
            char c = say.charAt(i);

            while ((++ i < say.length()) && (say.charAt(i) == c)) {
                count ++;
            }

            res += count + "" + c;
        }

        return res;
    }

    public static void main(String [] args) {
        System.out.print(countAndSay(9));
    }
}
