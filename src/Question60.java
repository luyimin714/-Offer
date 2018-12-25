public class Question60 {
    /**
     *              n个骰子的点数
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s，
     * 输入n，打印出s的所有可能的值出现的概率。
     */
    private static final int maxValue = 6;

    //解法1：基于递归求骰子点数，时间效率不够高
    public void printProbability1(int n) {
        if (n < 1) return;

        int maxSum = n * maxValue;
        int[] probabilities = new int[maxSum - n + 1];

        probability(n, probabilities);

        double sum = 0;

        double total = Math.pow(maxValue, n);
        for (int i = n; i <= maxSum; i++) {
            double ratio = probabilities[i - n] / total;
            sum += ratio;
            System.out.println(i + " " + ratio);
        }
        System.out.println(sum);
    }

    private void probability(int n, int[] probabilities) {
        for (int i = 1; i <= maxValue; i++) { //初始化第一个骰子的点数
            probability(n, n, i, probabilities);
        }
    }

    private void probability(int original, int current, int sum, int[] probabilities) {
        if (current == 1) {
            probabilities[sum - original]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probability(original, current-1, i+sum, probabilities);
            }
        }
    }

    //解法2：基于循环求骰子点数，时间性能好
    /* 假设f(m,n)表示投第m个骰子时，点数之和n出现的次数,投第m个骰子时的点数之和只与投第m-1个骰子时有关。
     * 递归方程：f(m,n)=f(m-1,n-1)+f(m-1,n-2)+f(m-1,n-3)+f(m-1,n-4)+f(m-1,n-5)+f(m-1,n-6)，
     * 表示本轮点数和为n出现次数等于上一轮点数和为n-1，n-2，n-3，n-4，n-5，n-6出现的次数之和。
     * 初始条件：第一轮的f(1),f(2),f(3),f(4),f(5),f(6)均等于1.
     */
    public void printProbability2(int number) {
        if (number < 1) return;

        int[][] probabilities = new int[2][maxValue*number+1];

        int flag = 0;

        for (int i = 1; i <= maxValue; i++) //初始条件：第一轮的f(1),f(2),f(3),f(4),f(5),f(6)均等于1.
            probabilities[flag][i] = 1;

        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) //第k次掷骰子，和最小为k，小于k的情况是不可能发生的
                probabilities[1-flag][i] = 0;

            for (int i = k; i <= maxValue * k; i++) {//第k次掷骰子，和最小为k，最大为maxValue*k
                probabilities[1-flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++)
                    probabilities[1-flag][i] += probabilities[flag][i-j];
            }
            flag = 1 - flag;
        }

        double sum = 0;
        double total = Math.pow(maxValue, number);
        for (int i = number; i <= maxValue * number; i++) {
            double ratio = probabilities[flag][i] / total;
            sum += ratio;
            System.out.println(i + " " + ratio);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Question60 test = new Question60();
        test.printProbability1(5);
        System.out.println();
        test.printProbability2(5);
    }
}
