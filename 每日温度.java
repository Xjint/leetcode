import java.util.Stack;
public class 每日温度 {
    /*
     * 依次将每日温度的索引存入栈中，直到某一天的温度大于栈顶元素索引所对应的温度，取出栈顶元素
     *
     * 栈中的索引对应的值是递减的，也就是栈顶索引对应的是截止到这一天为止最小的温度*/
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int n : new 每日温度().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) {
            System.out.print(n + "\t");
        }
    }
}