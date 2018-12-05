import java.util.LinkedList;
import java.util.List;

public class Question62 {
    /*
     *  圆圈中最后剩下的数
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }

    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1) return -1;

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
            list.add(i);

        int cur = (m - 1) % list.size();
        while (list.size() > 1) {
            list.remove(cur);
            cur = (cur + (m - 1)) % list.size();
        }

        return list.get(0);
    }
}
