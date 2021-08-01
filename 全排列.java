import java.util.ArrayList;
import java.util.List;

public class 全排列 {

  public static List<List<Integer>> allSort(List<Integer> list) {
    List<List<Integer>> ans = new ArrayList<>();
    int len = list.size();
    boolean[] used = new boolean[len];
    List<Integer> path = new ArrayList<>();
    backTracking(list, 0, len, used, path, ans);
    return ans;
  }

  private static void backTracking(List<Integer> list, int depth, int len, boolean[] used,
      List<Integer> path, List<List<Integer>> ans) {
    if (depth == list.size()) {
      ans.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < len; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      Integer e = list.get(i);
      path.add(e);
      backTracking(list, depth + 1, len, used, path, ans);
      used[i] = false;
      path.remove(path.size() - 1);
    }
  }
}
