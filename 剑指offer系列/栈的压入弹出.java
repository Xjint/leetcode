package 剑指offer系列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 
 * 假设压入栈的所有数字均不相等。
 * 
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 
 */
public class 栈的压入弹出 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        /**
         * 每压入栈中一个元素，都有可能出栈，所以： 每入栈一个元素，循环判断栈顶元素是否等于弹出序列的第i个元素，i初始为0；
         * 
         * 若不相等，继续入栈再判断；若相等，将该元素出栈，i++，一直到所有元素压入栈或者i > popped.length
         * 
         * 判断栈内是否为空，为空说明满足，反之不满足
         */
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (var push : pushed) {
            stack.push(push);
            while (index < popped.length && !stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                ++index;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 4, 3, 5, 1, 2 };
        System.out.println(validateStackSequences(pushed, popped));

    }
}
