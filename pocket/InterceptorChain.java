package pocket;

import java.util.List;

/**
 * @author baijintao
 * @date 2021/5/24 8:01 下午
 */
public class InterceptorChain {

  private List<Interceptor> interceptors;

  public <T> T pluginAll(T target) {
    T proxy = target;
    for (Interceptor interceptor : interceptors) {
      proxy = interceptor.plugin(proxy);
    }
    return proxy;
  }

}
