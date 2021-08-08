import java.util.Arrays;

/**
 * @author baijintao
 * @date 2021/8/8 10:03 下午
 * <p>
 * <p>
 * <p>
 * 给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
 * <p>
 * <p>
 * 输入： [1,1,1] 返回值： 1
 */
public class 数组中的最长连续子序列 {

  public static int MLS(int[] arr) {
    // write code here
    if (arr == null || arr.length == 0) {
      return 0;
    }
    Arrays.sort(arr);
    int count = 1;
    int temp = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]){
        continue;
      }
      if (arr[i] == arr[i - 1] + 1) {
        temp++;
      } else {
        count = Math.max(count, temp);
        temp = 1;
      }
    }
    return Math.max(count,temp);
  }

  public static void main(String[] args) {
    System.out.println(MLS(new int[]{7,8,2,6,1,1,7,2,4,3,4,7,5,6,8,2}));
  }

}
