package pocket;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author baijintao
 * @date 2021/5/24 7:31 下午
 */
public class ProxyUtil {

  private ProxyUtil() {
  }

  public static <T> T wrap(T t, Interceptor interceptor) {
    return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(),
        new Handler(t, interceptor));
  }
}
