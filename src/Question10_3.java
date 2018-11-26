public class Question10_3 {
    /*
     *              矩形覆盖
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
     * 总共有多少种方法？
     */
    public int RectCover(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int f1 = 2;
        int f2 = 1;
        int f = 0;
        for (int i = 3; i <= n; i++) {
            f = f1 + f2;

            f2 = f1;
            f1 = f;
        }
        return f;
    }
}
