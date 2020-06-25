package 动态规划系列;

/**
 * Created by jintao.bai on 2020/5/28 22:19
 */
public class 打家劫舍1 {
    public int rob(int[] nums) {
        //dp[i]表示偷到i的时候的最大价值
        //dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        //
        int len = nums.length;
        int[] dp = new int[len + 2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        return dp[len + 1];
    }

    //由于第i个的值只与i-1、i-2有关，所以只需要用两个变量保存
    public int robV2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int one = nums[0];
        int two = Math.max(one, nums[1]);
        int temp;
        for (int i = 2; i < nums.length; i++) {
            temp = two;
            two = Math.max(one + nums[i], two);
            one = temp;
        }
        return two;
    }
}
