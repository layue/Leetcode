/**
 * Created by X on 09/04/2016.
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


 */
public class Solution28 {
    public static int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) {
            return -1;
        }

        for(int i = 0; i <= haystack.length() - needle.length(); i ++) {
            int j = 0;
            for(int pos = i; j < needle.length() && haystack.charAt(pos) == needle.charAt(j); j ++, pos ++);
            if(j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.print(strStr("123456","23"));
    }
}
