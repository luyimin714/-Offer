import java.util.ArrayList;

public class Question57 {
    /*
     * 和为S的两个数字
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int target) {
        if (array == null || array.length < 1)
            return new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int sum = array[start] + array[end];
            if (sum == target) {
                list.add(array[start]);
                list.add(array[end]);
                break;
            } else if (sum < target)
                start++;
            else
                end--;
        }
        return list;
    }

    /*
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        if (numbers == null || numbers.length <= 0)
            return res;

        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            long sum = numbers[start] + numbers[end];

            if (sum == target) {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            } else if (sum > target)
                end--;
            else
                start++;
        }
        return res;
    }
}
