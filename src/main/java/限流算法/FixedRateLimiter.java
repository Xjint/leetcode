package 限流算法;

/**
 * 固定窗口限流
 * <p>
 * 规定每秒内的请求数量不得大于n个
 *
 * @author baijintao
 * @date 2021/10/9 4:24 下午
 */
public class FixedRateLimiter implements RateLimiter {

  private final int MAX;

  private int count;

  private long last;

  public FixedRateLimiter(int max) {
    MAX = max;
  }

  @Override
  public boolean pass() {
    long now = System.currentTimeMillis();
    if (now - last > 1000) {
      last = now;
      count = 0;
    }
    if (count >= MAX) {
      return false;
    }
    ++count;
    return true;
  }
}
