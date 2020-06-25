import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 打开转盘锁 {
    public static void main(String[] args) {
        int count = new 打开转盘锁().openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202");
        System.out.println("result is : " + count);
    }

    public int openLock(String[] deadends, String target) {
        if (contains(deadends, "0000")) {
            return -1;
        }
        int  count = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int[] meta = { -1, 1 };
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String top = queue.poll();
                if (top.equals(target)) {
                    return count;
                }
                if (contains(deadends, top)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    for (int m : meta) {
                        int tmp = ((top.charAt(j) - '0') + m) % 10;
                        String newS = top.substring(0, j) + ("" + tmp) + top.substring(j + 1);
                        if (!visited.contains(newS)) {
                            queue.add(newS);
                        }
                    }
                }
            }
            ++count;
        }
        return -1;
    }

    private boolean contains(String[] deadends, String string) {
        for (String value : deadends) {
            if (value.equals(string)) {
                return true;
            }
        }
        return false;
    }
}