import java.util.LinkedList;
import java.util.List;

public class Question62 {
    /**
     *                  圆圈中最后剩下的数
     *  0, 1, … , n-1 这n个数字排成一个圈圈，从数字0开始每次从圆圏里删除第m个数字。
     *  求出这个圆圈里剩下的最后一个数字。
     */

    //解法1：用环形链表模拟圆圈
    public int lastRemaining1(int n, int m) {
        if (n < 1 || m < 1) return -1;

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
            list.add(i);

        //第一个被删除的数字
        int cur = (m - 1) % list.size();

        while (list.size() > 1) {
            list.remove(cur);
            cur = (cur + (m - 1)) % list.size();
        }

        return list.get(0);
    }

    //解法1：用数组模拟圆圈
    public int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) return -1;

        int[] nums = new int[n];
        int i = -1, step = 0, count = n;

        while (count > 0) {                     //跳出循环时将最后一个元素也设置为了-1
            i++;                                //指向上一个被删除对象的下一个元素。

            if (i >= n) i = 0;                  //模拟环
            if (nums[i] == -1) continue;        //跳过被删除的对象
            step++;                             //记录已走过的
            if (step == m) {                    //找到待删除的对象
                step = 0;
                nums[i] = -1;
                count--;
            }
        }
        return i;                               //返回跳出循环时的i,即最后一个被设置为-1的元素
    }

    //解法2
    //定义f(n,m)表示每次在n个数字(0,1,...,n-1)中删除第m个数字最后剩下的数字
    //f(n,m) =        0         ,n=1
    //         [f(n-1,m)+m]%n   ,n>1
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }
}
