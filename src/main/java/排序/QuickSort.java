package 排序;

import java.util.Arrays;

/**
 * @author baijintao
 * @date 2021/9/16 6:53 下午
 */
public class QuickSort {

  public static void quickSort(int[] arr) {
    doQuickSort(arr, 0, arr.length - 1);
  }

  private static void doQuickSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivot = partition(arr, left, right);
    doQuickSort(arr, left, pivot);
    doQuickSort(arr, pivot + 1, right);
  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[left];
    while (left < right) {
      while (arr[right] >= pivot && left < right) {
        right--;
      }
      arr[left] = arr[right];
      while (arr[left] <= pivot && left < right) {
        left++;
      }
      arr[right] = arr[left];
    }
    arr[left] = pivot;
    return left;
  }

  public static void main(String[] args) {
    int[] arr = {5, 3, 1, 2, 6, 7, 4};
    quickSort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
