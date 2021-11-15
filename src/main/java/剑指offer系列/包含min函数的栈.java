package 剑指offer系列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class 包含min函数的栈 {

    /** initialize your data structure here. */

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public 包含min函数的栈() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }

    }

    public void pop() {
        int top = stack.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();

    }

    public int min() {
        return minStack.peek();
    }
}
