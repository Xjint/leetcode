package 动态规划系列;

/**
 * @author baijintao
 * @date 2021/10/23 10:54 上午
 */
public class 跳台阶 {

  public int jumpFloor(int target) {
    //dp[n] = dp[n-1] + dp[n-2]
    int left = 1;
    int right = 1;
    if (target < 2) {
      return target;
    }
    for (int i = 2; i <= target; i++) {
      int right1 = left + right;
      left = right;
      right = right1;
    }
    return right;
  }
}
