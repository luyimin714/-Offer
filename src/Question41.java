import java.util.Comparator;
import java.util.PriorityQueue;

public class Question41 {
    private int count = 0;

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void Insert(Integer num) {
        count++;

        if (count % 2 == 0) {
            maxHeap.offer(num);
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        } else {
            minHeap.offer(num);
            int temp = minHeap.poll();
            maxHeap.offer(temp);
        }
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double(maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return new Double(maxHeap.peek());
        }
    }
}
