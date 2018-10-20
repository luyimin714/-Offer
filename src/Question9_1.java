import java.util.LinkedList;
import java.util.Queue;

public class Question9_1 {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public void push(int x){
        q1.add(x);
        top = x;
    }

    public int pop(){
        while (q1.size() > 1){
            top = q1.remove();
            q2.add(top);
        }
        int a = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return a;
    }

    public int top(){
        return top;
    }

    public boolean empty(){
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        Question9_1 stack = new Question9_1();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
    }
}
