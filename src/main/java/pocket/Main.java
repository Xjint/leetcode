package pocket;

/**
 * @author baijintao
 * @date 2021/5/24 7:25 下午
 */
public class Main {

  public static void main(String[] args) {
    Service service = new ServiceImpl();
    Interceptor interceptorA = new InterceptorA();
    Interceptor interceptorB = new InterceptorB();
    Service wrap = interceptorA.plugin(service);
    wrap = interceptorB.plugin(wrap);
    wrap.service();
  }
}
