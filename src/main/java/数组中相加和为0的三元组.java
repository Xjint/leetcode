import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baijintao
 * @date 2021/8/1 10:41 下午
 */
public class 数组中相加和为0的三元组 {

  /**
   * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
   * <p>
   * 注意：
   * <p>
   * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
   * <p>
   * 解集中不能包含重复的三元组。
   */
  public static List<List<Integer>> threeSum(int[] num) {
    List<List<Integer>> ans = new ArrayList<>();
    if (num == null || num.length < 3) {
      return ans;
    }
    Arrays.sort(num);
    for (int i = 0; i < num.length; i++) {
      int target = num[i];
      if (target > 0) {
        return ans;
      }
      int left = i + 1;
      int right = num.length - 1;
      while (left < right) {
        int sum = target + num[left] + num[right];
        if (sum == 0) {
          ans.add(Arrays.asList(target, num[left], num[right]));
          while (left < right && num[left + 1] == num[left]) {
            left++;
          }
          left++;
          while (left < right && num[right - 1] == num[right]) {
            right--;
          }
          right--;
        } else if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    List<List<Integer>> lists = threeSum(new int[]{-2, 0, 1, 1, 2});
    for (List<Integer> list : lists) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

}
