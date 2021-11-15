import java.util.ArrayList;
import java.util.Comparator;

/**
 * 给出一组区间，请合并所有重叠的区间。 请保证合并后的区间按区间起点升序排列。
 * <p>
 * <p>
 * 输入： [[10,30],[20,60],[80,100],[150,180]]
 * <p>
 * 返回值： [[10,60],[80,100],[150,180]]
 *
 * @author baijintao
 * @date 2021/10/18 8:23 下午
 */
public class 合并区间 {

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    if (intervals.size() < 2) {
      return intervals;
    }
    intervals.sort(Comparator.comparingInt(a -> a.start));
    ArrayList<Interval> ans = new ArrayList<>();
    for (int i = 1; i < intervals.size(); i++) {
      if (intervals.get(i).start <= intervals.get(i - 1).end) {
        intervals.get(i).start = Math.min(intervals.get(i).start, intervals.get(i - 1).start);
        intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
      } else {
        ans.add(intervals.get(i - 1));
      }
    }
    ans.add(intervals.get(intervals.size() - 1));
    return ans;
  }

}

class Interval {

  int start;
  int end;

  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }
}
