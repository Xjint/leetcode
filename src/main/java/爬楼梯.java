/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 输入： 3
 * 
 * 输出： 3
 * 
 * 解释： 有三种方法可以爬到楼顶。
 * 
 * 1. 1 阶 + 1 阶 + 1 阶
 * 
 * 2. 1 阶 + 2 阶
 * 
 * 3. 2 阶 + 1 阶
 */
public class 爬楼梯 {
    public int climbStairs(int n) {
        // f(n) = f(n-1) + f(n-2) f(1) = 1, f(2) = 2   //此为递归
        if (n <= 2) {
            return n;
        }
        int left = 1, right = 2;
        int temp;
        for (int i = 0; i < n - 2; i++) {
            temp = left + right;
            left = right;
            right = temp;
        }
        return right;

    }

}
