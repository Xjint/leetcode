package 动态规划系列;

/**
 * Created by jintao.bai on 2020/5/27 21:47
 */
public class 买卖股票1 {
    public int maxProfit(int[] prices) {
        //第i天的收益 = max(第i-1天的收益,第i天的价格-前i天的最小值)
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            ans = Math.max(ans, price - min);
        }
        return ans;

    }
}
