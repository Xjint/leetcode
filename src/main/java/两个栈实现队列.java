import java.util.Stack;

public class 两个栈实现队列 {
    private Stack<Integer> mainStack;
    private Stack<Integer> support;

    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和
     * deleteHead，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1)
     * 
     */
    public 两个栈实现队列() {
        mainStack = new Stack<>();
        support = new Stack<>();
    }

    public void appendTail(int value) {
        mainStack.push(value);
    }

    public int deleteHead() {
        if (mainStack.empty()) {
            return -1;
        }
        while (!mainStack.empty()) {
            support.push(mainStack.pop());
        }
        int temp = support.pop();
        while (!support.empty()) {
            mainStack.push(support.pop());
        }
        return temp;
    }
}