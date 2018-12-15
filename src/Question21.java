import java.util.Arrays;

public class Question21 implements Foo {
    /**
     *         调整数组顺序使奇数位于偶数前面
     *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    //牛客网
    //1.要想保证原有次序，则只能顺次移动或相邻交换。
    //2.i从左向右遍历，找到第一个偶数。
    //3.j从i+1开始向后找，直到找到第一个奇数。
    //4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
    //5.终止条件：j向后遍历查找失敗。
    public void reOrderArray(int [] nums) {
        if (nums == null || nums.length == 0) return;

        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && !isEven(nums[i]))
                i++;

            int j = i + 1;
            while (j < nums.length && isEven(nums[j]))
                j++;

            if (j < nums.length) {
                int temp = nums[j];
                for (int k = j - 1; k >= i; k--) {
                    nums[k + 1] = nums[k];
                }
                nums[i] = temp;

                i++;
            } else {
                break;
            }
        }
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    //剑指Offer 不需要偶数和偶数之间的相对位置不变
    public void ReorderOddEven(int[] nums, Foo foo) {
        if (nums == null || nums.length == 0) return;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            while (start < end && !foo.func(nums[start]))  //(nums[start] & 0x1) != 0
                start++;
            while (start < end && foo.func(nums[end]))  //(nums[end] & 0x1) == 0
                end--;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
    }

    public boolean func (int n) {
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Question21().ReorderOddEven(nums, new Question21());
        System.out.println(Arrays.toString(nums));
    }
}
