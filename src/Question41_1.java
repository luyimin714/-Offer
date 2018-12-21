import java.util.TreeSet;

public class Question41_1 {
    /**
     *      数据流中的中位数
     */
    //TreeSet
    private TreeSet<Integer> max = new TreeSet<>();
    private TreeSet<Integer> min = new TreeSet<>();

    public void Insert(int num) {
        if (((max.size() + min.size()) & 1) == 0) {
            if (max.size() > 0 && num < max.last()) {
                max.add(num);
                num = max.last();
                max.remove(num);
            }
            min.add(num);
        } else {
            if (min.size() > 0 && num > min.first()) {
                min.add(num);
                num = min.first();
                min.remove(num);
            }
            max.add(num);
        }
    }

    public Double GetMedian() {
        double mid = 0.0;
        int size = max.size() + min.size();
        if (size == 0)
            return mid;
        if ((size & 1) == 1)
            mid = (double) min.first();
        else
            mid = (max.last() + min.first()) / 2.0;

        return mid;
    }
}
