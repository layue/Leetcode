import java.util.Stack;

/**
 * Created by X on 28/03/2016.
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses SUBSTRING.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Solution32 {
    public static int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }

        Stack<String> sta = new Stack<>();
        sta.push(s.substring(0, 1));

        int count = 0;

        for(int i = 1; i < s.length(); i ++) {
            if (!sta.empty() && sta.peek().equals("(") && s.charAt(i) == ')') {
                    sta.pop();
                    count += 2;
            } else {
                sta.push(s.substring(i, i + 1));
            }
        }
        return count;
    }

    public static void main(String [] args) {
        System.out.print(longestValidParentheses("((((((((("));
    }
}
