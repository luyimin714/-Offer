import java.util.ArrayDeque;
import java.util.Deque;

public class QueueWithMax<T extends Comparable> {
    private Deque<InternelData<T>> data;
    private Deque<InternelData<T>> maximums;
    private int currentIndex;
    private QueueWithMax() {
        this.data = new ArrayDeque<>();
        this.maximums = new ArrayDeque<>();
        this.currentIndex = 0;
    }

    public void push_back(T number) {
        while (!maximums.isEmpty() && number.compareTo(maximums.getLast().number) >= 0)
            maximums.pollLast();
        InternelData<T> internelData = new InternelData<>(number, currentIndex);
        data.addLast(internelData);
        maximums.addLast(internelData);

        currentIndex++;
    }

    public void pop_front() {
        if (maximums.isEmpty())
            return;

        if (maximums.getFirst().index == data.getFirst().index)
            maximums.pollFirst();

        data.pollFirst();
    }

    public T max() {
        if (maximums.isEmpty())
            return null;
        return maximums.getFirst().number;
    }

    private static class InternelData<T extends Comparable> {
        T number;
        int index;
        InternelData(T number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        QueueWithMax<Integer> queue = new QueueWithMax<>();
        queue.push_back(3);
        System.out.println(queue.max());
        queue.push_back(5);
        System.out.println(queue.max());
        queue.push_back(1);
        System.out.println(queue.max());

        System.out.println("出队");
        System.out.println(queue.max());
        queue.pop_front();
        System.out.println(queue.max());
        queue.pop_front();
        System.out.println(queue.max());
        queue.pop_front();
        System.out.println(queue.max());

    }
}
