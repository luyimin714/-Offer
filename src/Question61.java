import java.util.Arrays;

public class Question61 {
    /*
     * 扑克牌顺子
     */
    public boolean isContinuous(int [] nums) {
        if (nums == null || nums.length < 1)
            return false;

        Arrays.sort(nums);

        int numOfZero = 0;
        int numOfGap = 0;

        for (int i = 0; i < nums.length && nums[i] == 0; i++)
            numOfZero++;

        int small = numOfZero;
        int big = small + 1;
        while (big < nums.length) {
            if (nums[small] == nums[big])
                return false;

            numOfGap += nums[big] - nums[small] - 1;
            small = big;
            big++;
        }

        return numOfZero >= numOfGap;
    }

    public static void main(String[] args) {
        Question61 test = new Question61();
        int[] nums = {0, 0, 1, 2, 3};
        System.out.println(test.isContinuous(nums));
    }
}
