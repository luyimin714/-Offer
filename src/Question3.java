import java.util.Arrays;
import java.util.Scanner;

public class Question3 {
    /*
    找出数组中重复的数字  在一个长度为 n 的数组里 所有数字的范围 0 - n-1
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication){
        if (numbers == null || numbers.length == 0)
            return false;
        for (int i = 0; i < length; i++){
            if (numbers[i] < 0 || numbers[i] > length-1)
                return false;
        }

        for (int i = 0; i < length; i++){
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
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

    public boolean duplicateWithSort(int[] numbers, int length, int[] duplication){
        if (numbers == null || numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        for (int i = 0; i < length; i++){
            if (numbers[i] == numbers[i+1]){
                duplication[0] = numbers[i];
                return false;
            }
        }
        return true;
    }

    public int getDuplication(int[] nums, int length){
        if (nums == null || length == 0)
            return -1;
        int start = 1, end = length - 1;
        while (end >= start){
            int mid = start + (end - start) / 2;
            int count = countRange(nums, length, start, mid);
            if (end == start){
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

    private int countRange(int[] nums, int length, int start, int end){
        if (nums == null)
            return 0;
        int count = 0;
        for (int i = 0; i < length; i++){
            if (nums[i] >= start && nums[i] <= end)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[8];
        for (int i = 0; i < input.length; i++){
            input[i] = scanner.nextInt();
        }
    }
}
