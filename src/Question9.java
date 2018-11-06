import java.util.Stack;

public class Question9 {
    /****************************************************************
                            用两个栈实现队列
     用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     ***************************************************************/
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x){
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    private int peek() {
        if (output.empty()){
            while (!input.empty())
                output.push(input.pop());
        }
        return output.peek();
    }

    private boolean empty(){
        return input.empty() && output.empty();
    }
}
