/**
 * Created by jintao.bai on 2020/5/27 11:37
 * 给一个数组，使数组奇数在前半段，偶数在后半段，在原数组上操作。
 */
public class 奇偶数组排序 {
    /*用两个指针，从首尾向中间遍历，直至相交*/
    public static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < array.length && (array[left] & 1) == 1) {
                ++left;
            }
            while (right >= 0 && (array[right] & 1) != 1) {
                --right;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 4, 5};
        sort(a);
        for (int i : a) {
            System.out.println(i + "\t");
        }
    }

}
