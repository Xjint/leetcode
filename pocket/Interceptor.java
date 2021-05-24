package pocket;

/**
 * @author baijintao
 * @date 2021/5/24 7:37 下午
 */
public interface Interceptor {

  Object intercept(Invocation target) throws Exception;

  default <T> T plugin(T target) {
    return ProxyUtil.wrap(target, this);
  }

}
