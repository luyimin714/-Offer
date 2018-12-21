import java.util.Comparator;
import java.util.PriorityQueue;

public class Question41 {
    /**
     *                 数据流中的中位数
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
     * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中
     * 读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平
     * 均值。我们使用Insert()方法读取数据流，使用GetMedian()方法
     * 获取当前读取数据的中位数。
     */
    //PriorityQueue
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) { //数据的数目是偶数时插入最小堆
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (minHeap.size() > 0 && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        double mid = 0;
        int size = maxHeap.size() + minHeap.size();
        if (size == 0) return mid;
        if ((size & 1) == 1) {
            mid = (double)(minHeap.peek());
        } else {
            mid = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return mid;
    }
}
