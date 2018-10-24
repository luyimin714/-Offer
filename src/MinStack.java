import java.util.Stack;

public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min)
                min = x;
        }
    }

    public void pop() {
        if (stack.empty())
            return;

        long pop = stack.pop();

        if (pop < 0)
            min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0)
            return (int)(top + min);
        else
            return (int)min;
    }

    public int getMin() {
        return (int)min;
    }
}
