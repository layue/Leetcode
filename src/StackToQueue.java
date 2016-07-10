import java.util.Stack;

/**
 * Created by X on 10/07/2016.
 * Implement Queue by Two Stacks
 */
public class StackToQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackToQueue() {
        // do initialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        top();
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if(stack1.isEmpty()) {
            if(stack2.isEmpty()) {
                System.out.println("Invalid operation");
                return -1;
            }
        } else {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.peek();
    }

    public static void main(String [] args) {
        StackToQueue queue = new StackToQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.top());
        queue.push(3);
    }
}
