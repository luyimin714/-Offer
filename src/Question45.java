import java.util.Arrays;
import java.util.Comparator;

public class Question45 {
    /****************************************************************
     *                  把数组排成最小的数
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
     * 则打印出这三个数字能排成的最小数字为321323。
     ****************************************************************/
    public String PrintMinNumber(int [] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] s_num = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_num[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s_num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 当返回值>0 即 (s1 > s2) 即 (o1 + o2 > o2 + o1) 时
                // 即 o2 和 o1 组成的数更小，而 o2 在 o1 后面时
                // 即 o1 和 o2 组成的数更大，而 o1 在 o2 前面时
                // 进行交换，即排序
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        if (s_num[s_num.length - 1].charAt(s_num[s_num.length - 1].length()-1) == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : s_num) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "1234";
        String s2 = "1235";
        String s3 = "123";
        System.out.println(s1.compareTo(s1));
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));

        int[] nums = {3, 32, 321};
        Question45 test = new Question45();
        System.out.println(test.PrintMinNumber(nums));
    }
}
