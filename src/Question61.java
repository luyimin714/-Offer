import java.util.Arrays;

public class Question61 {
    /**
     *                      扑克牌顺子
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这五张牌是不是连续的，
     * 2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
     */
    public boolean isContinuous(int [] nums) {
        if (nums == null || nums.length < 1) return false;

        Arrays.sort(nums);

        int numOfZero = 0;
        int numOfGap = 0;

        for (int i = 0; i < nums.length && nums[i] == 0; i++)
            numOfZero++;

        //统计数组中的间隔数目
        int small = numOfZero;
        int big = small + 1;
        while (big < nums.length) {
            //两个数相等，有对子，不可能是顺子
            if (nums[small] == nums[big]) return false;

            numOfGap += nums[big] - nums[small] - 1;
            small = big;
            big++;
        }

        return numOfZero >= numOfGap;
    }

    public static void main(String[] args) {
        Question61 test = new Question61();
        int[] nums = {0, 0, 1, 2, 3, 5, 7, 9};
        System.out.println(test.isContinuous(nums));
    }
}
