import java.util.ArrayList;
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
}