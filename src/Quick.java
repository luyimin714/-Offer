public class Quick {
    /**************************************************
                         快速排序
     **************************************************/
    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        if (lo == hi) return lo;

        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] <= v) if (i == hi) break;
            while (v <= a[--j]) if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 7, 9, 0, 1, 4, 6, 6, 8};
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();

        sort(a, 0, a.length-1);

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
