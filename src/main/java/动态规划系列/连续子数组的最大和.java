package 动态规划系列;

/**
 * 输入一个长度为n的整型数组a，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * <p>
 * <p>
 * 输入[1,-2,3,10,-4,7,2,-5]  输出18
 * <p>
 * 说明：输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和 18。
 *
 * @author baijintao
 * @date 2021/9/28 4:12 下午
 */
public class 连续子数组的最大和 {

  public static int FindGreatestSumOfSubArray(int[] array) {

    //暴力枚举
//    int len = array.length;
//    int ans = 0;
//    for (int i = 0; i < len; i++) {
//      int temp = 0;
//      for (int j = i; j < len; j++) {
//        temp += array[j];
//        ans = Math.max(ans, temp);
//      }
//    }
//    return ans;


    /*
     * f(n) = Math.max(arr[n],arr[n] + f(n-1));
     * */

    int cur = 0;
    int ans = Integer.MIN_VALUE;
    for (int a : array) {
      cur = Math.max(a, cur + a);
      ans = Math.max(ans, cur);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
  }
}
