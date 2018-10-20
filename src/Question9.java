import java.util.Stack;

public class Question9 {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x){
        input.push(x);
    }

    public void poo(){
        peek();
        output.pop();
    }

    private int peek(){
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
