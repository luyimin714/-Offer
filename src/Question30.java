import java.util.Stack;

public class Question30 {
    /**
     *    包含min函数的栈
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */

    //剑指offer
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
        //assert data.size() > 0 && min.size() > 0;
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        //assert data.size() > 0 && min.size() > 0;
        return min.peek();
    }
}
