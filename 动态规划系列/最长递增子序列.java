package 动态规划系列;

/**
 * 子串是连续的，子序列不一定是连续的
 * <p>
 * <p>
 * <p>
 * f(i) 为 以元素arr[i]结尾的lis序列长度
 * <p>
 * f(i) =
 *
 * @author baijintao
 * @date 2021/8/2 7:29 下午
 */
public class 最长递增子序列 {

  /*
   *
   *  给定数组arr，设长度为n，输出arr的最长递增子序列。
   * （如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
   * */
  public int[] LIS(int[] arr) {

    return arr;
  }


  //求最长递增子序列的长度
  public int lengthLIS(int[] arr) {
    int max = 1;
    int[] dp = new int[arr.length];
    dp[0] = 1;
    for (int i = 1; i < arr.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }

}
