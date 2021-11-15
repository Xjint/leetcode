package pocket;

/**
 * @author baijintao
 * @date 2021/5/24 7:39 下午
 */
public class InterceptorA implements Interceptor {

  @Override
  public Object intercept(Invocation target) throws Exception {
    System.out.println("A before");
    Object process = target.process();
    System.out.println("A after");
    return process;
  }
}
