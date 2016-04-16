import java.util.Stack;

/**
 * Created by X on 14/04/2016.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if((stack.peek() == '(' && s.charAt(i) == ')') ||
                    (stack.peek() == '{' && s.charAt(i) == '}') ||
                    (stack.peek() == '[' && s.charAt(i) == ']'))
            {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "(({{[()]}}";
        System.out.print(isValid(s));
    }
}
