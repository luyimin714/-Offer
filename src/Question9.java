import java.util.Stack;

public class Question9 {
    /**
     *                       用两个栈实现队列
     *用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */

    //leetcode
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    public void push(int x){
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.empty()){
            while (!input.empty())
                output.push(input.pop());
        }
        return output.peek();
    }

    public boolean empty(){
        return input.empty() && output.empty();
    }

    //剑指offer
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push2(int node) {
        stack1.push(node);
    }

    public int pop2() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
