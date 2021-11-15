package pocket;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author baijintao
 * @date 2021/5/24 7:30 下午
 */
public class Handler implements InvocationHandler {

  private final Object target;
  private final Interceptor interceptor;

  public Handler(Object t, Interceptor interceptor) {
    this.target = t;
    this.interceptor = interceptor;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Invocation invocation = new Invocation(target, method, args);
    return interceptor.intercept(invocation);
  }
}
