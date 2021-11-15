package 限流算法;

/**
 * @author baijintao
 * @date 2021/10/9 4:23 下午
 */
public interface RateLimiter {

  /**
   * @return true: 通过   false: 拒绝
   */
  boolean pass();

}
