public class Question64 {
    /*
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、
     * switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        Question64 test = new Question64();
        System.out.println(test.Sum_Solution(100));
    }
}
