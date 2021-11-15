package pocket;

/**
 * @author baijintao
 * @date 2021/5/24 7:39 下午
 */
public class InterceptorB implements Interceptor {

  @Override
  public Object intercept(Invocation target) throws Exception {
    System.out.println("B before");
    Object process = target.process();
    System.out.println("B After");
    return process;
  }
}
