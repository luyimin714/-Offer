import java.util.ArrayList;

public class Question57_1 {
    /**
     *                 和为S的连续正数序列
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
     * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快
     * 的找出所有和为S的连续正数序列? Good Luck!
     */

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (sum < 3) return res;

        int small = 1, big = 2;
        int mid = (sum + 1) / 2;
        int curSum = small + big;

        while (small < mid) {
            if (curSum == sum)
                res.add(continuousSequence(small, big));

            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;

                if (curSum == sum)
                    res.add(continuousSequence(small, big));
            }

            big++;
            curSum += big;
        }

        return res;
    }

    private ArrayList<Integer> continuousSequence(int small, int big) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(9 / 2);
    }
}
