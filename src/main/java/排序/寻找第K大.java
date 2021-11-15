package 排序;

import java.util.Arrays;

/**
 * @author baijintao
 * @date 2021/8/21 10:21 上午
 */
public class 寻找第K大 {

  public static int quickSort(int[] array, int k) {
    return quickSort(array, 0, array.length, k);
  }

  private static int quickSort(int[] array, int left, int right, int k) {
    if (left >= right) {
      return array[left];
    }
    int pivot = array[left];
    int i = left, j = right - 1;
    while (i < j) {
      while (j > i && array[j] >= pivot) {
        --j;
      }
      while (i < j && array[i] <= pivot) {
        ++i;
      }
      swap(array, i, j);
    }
    //最终找到了第left
    if (left == k) {
      return array[left];
    } else if (left < k) {
      swap(array, i, left);
      return quickSort(array, left + 1, right, i);
    } else {
      swap(array, i, left);
      return quickSort(array, left, right - 1, k);
    }
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args) {
    int[] array = {6, 5, 4, 3, 21, 7, 8, 96, 324, 432, 1};
    int ans = quickSort(array, 1);
    System.out.println(ans);
    System.out.println(Arrays.toString(array));
  }


}
