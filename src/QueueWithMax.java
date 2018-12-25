import java.util.ArrayDeque;
import java.util.Deque;

public class QueueWithMax<T extends Comparable> {
    /**
     *          队列的最大值
     * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max、
     * push_back和pop_front的时间复杂度都是O(1)。
     */
    private Deque<InternalData<T>> data;
    private Deque<InternalData<T>> maximums;
    private int currentIndex;

    public QueueWithMax() {
        this.data = new ArrayDeque<>();
        this.maximums = new ArrayDeque<>();
        this.currentIndex = 0;
    }

    public void push_back(T number) {
        while (!maximums.isEmpty() && number.compareTo(maximums.getLast().number) >= 0)
            maximums.pollLast();
        InternalData<T> internalData = new InternalData<>(number, currentIndex);
        data.addLast(internalData);
        maximums.addLast(internalData);

        currentIndex++;
    }

    public void pop_front() {
        if (maximums.isEmpty()) return;

        if (maximums.getFirst().index == data.getFirst().index)
            maximums.pollFirst();

        data.pollFirst();
    }

    public T max() {
        if (maximums.isEmpty())
            return null;
        return maximums.getFirst().number;
    }

    private static class InternalData<T extends Comparable> {
        T number;
        int index;
        InternalData(T number, int index) {
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
