import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Question59 {
    /**
     *                  滑动窗口的最大值
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么
     * 一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；针对
     * 数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
     * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     */

    //牛客
    public ArrayList<Integer> maxInWindows(int [] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //用一个双端队列，队列第一个位置保存当前窗口最大值的索引，当窗口滑动一次：
            //2.新增加的值从队尾开始比较，把所有比他小的值丢掉
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i])
                queue.pollLast();
            //1.判断当前最大值是否过期
            while (!queue.isEmpty() && i - queue.getFirst() + 1 > size)
                queue.pollFirst();

            queue.add(i);

            if (size != 0 && i + 1 >= size)
                res.add(nums[queue.getFirst()]);
        }
        return res;
    }

    //剑指offer
    public ArrayList<Integer> maxInWindows2(int [] nums, int size) {
        if (nums == null || nums.length == 0 || size < 1 || size > nums.length)
            return new ArrayList<>();

        ArrayList<Integer> maxInWindows = new ArrayList<>();
        ArrayDeque<Integer> index = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!index.isEmpty() && nums[i] >= nums[index.getLast()])
                index.pollLast();

            index.add(i);
        }

        for (int i = size; i < nums.length; i++) {
            maxInWindows.add(nums[index.getFirst()]);

            while (!index.isEmpty() && nums[i] >= nums[index.getLast()])
                index.pollLast();
            if (!index.isEmpty() && index.getFirst() <= i - size)
                index.pollFirst();

            index.add(i);
        }
        maxInWindows.add(nums[index.getFirst()]);

        return maxInWindows;
    }
}
