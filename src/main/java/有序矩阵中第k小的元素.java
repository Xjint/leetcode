import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 有序矩阵中第k小的元素
 * <p>
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * <p>
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素
 */
public class 有序矩阵中第k小的元素 {

    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                list.add(anInt);
            }
        }
        list.sort(Comparator.naturalOrder());
        return list.get(k - 1);
    }

    public int kthSmallestV2(int[][] matrix, int k) {
        return Arrays
                .stream(matrix)
                .reduce(有序矩阵中第k小的元素::merge2Array)
                .orElse(new int[k])
                [k - 1];
    }

    /*合并两个有序数组*/
    public static int[] merge2Array(int[] array1, int[] array2) {
        int[] ans = new int[array1.length + array2.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            ans[index++] = array1[i] < array2[j] ? array1[i++] : array2[j++];
        }
        while (i < array1.length) {
            ans[index++] = array1[i++];
        }
        while (j < array2.length) {
            ans[index++] = array2[j++];
        }
        return ans;
    }
}