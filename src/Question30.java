import java.util.Stack;

public class Question30 {

    private Stack<Integer> data;
    private Stack<Integer> min;

    public Question30() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);

        if (min.empty() || x < min.peek())
            min.push(x);
        else
            min.push(min.peek());
    }

    public void pop() {
        assert data.size() > 0 && min.size() > 0;

        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        assert data.size() > 0 && min.size() > 0;

        return min.peek();
    }
}
