package 排序;

public class 快速排序 {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
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
        swap(array, i, left);
        quickSort(array, 0, i);
        quickSort(array, i + 1, right);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
