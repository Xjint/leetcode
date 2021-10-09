package 排序;

import java.util.Arrays;

/**
 * @author baijintao
 * @date 2021/9/16 5:53 下午
 */
public class BubbleSort {

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean change = false;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j + 1] < arr[j]) {
          swap(arr, j, j + 1);
          change = true;
        }
      }
      if (!change) {
        break;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
  }


  public static void main(String[] args) {
    int[] arr = {5, 3, 1, 2, 6, 7, 4};
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
