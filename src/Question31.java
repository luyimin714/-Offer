import java.util.Stack;

public class Question31 {
    /*
     * 栈的压入、弹出序列
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压
     * 栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序
     * 列的长度是相等的）
     */
    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || pop.length == 0)
            return false;

        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : push) {
            stack.push(num);
            while ((!stack.isEmpty()) && (stack.peek() == pop[i])) {
                stack.pop();
                i++;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};

        System.out.println(isPopOrder(push, pop1));
        System.out.println(isPopOrder(push, pop2));
    }
}
