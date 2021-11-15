import java.util.Arrays;

/**
 * @author baijintao
 * @date 2021/8/4 7:23 下午
 */
public class 有效三角形的个数611 {

  /**
   * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
   * <p>
   * <p>
   * <p>
   * 排序之后, 对于任意a < b < c,只需保证a + b > c即可，也就是确定a b 找到第一个小于a + b的c即可
   */
  public static int triangleNumber(int[] nums) {
    int count = 0;
    if (nums == null || nums.length < 3) {
      return 0;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        //二分查找第一个小于nums[i] + nums[j] 的下标
//        int left = i + 1;
//        int right = nums.length - 1;
//        while (left <= right) {
//          int mid = (right - left) / 2 + left;
//          if (nums[mid] == )
//        }
        int k = nums.length - 1;
        while (nums[k] >= nums[i] + nums[j] && k > j) {
          --k;
        }
        count += k - j;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
  }

}
