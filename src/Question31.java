import java.util.Stack;

public class Question31 {
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
