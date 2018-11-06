import java.util.Arrays;
import java.util.Scanner;

public class Question3 {
    /****************************************************************************
       题目一：数组中重复的数字
     在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，
     但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     ***************************************************************************/
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0)
            return false;
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
                return false;
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public boolean duplicateWithSort(int[] numbers, int[] duplication) {
        if (numbers == null || numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numbers[i+1]) {
                duplication[0] = numbers[i];
                return false;
            }
        }
        return true;
    }
    /***************************************************
     题目二：不修改数组找出重复的数字
     ***************************************************/
    public int getDuplication(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 1, end = nums.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            int count = countRange(nums, nums.length, start, mid);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > (mid - start + 1))
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }

    private int countRange(int[] nums, int length, int start, int end) {
        if (nums == null)
            return 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= start && nums[i] <= end)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3 ,4, 5, 5, 6, 6, 7, 8, 9, 10};
        int[] duplication = new int[nums.length];
        Question3 test = new Question3();
        System.out.println(test.duplicate(nums, nums.length,duplication));
        System.out.println(test.getDuplication(nums));
    }
}
