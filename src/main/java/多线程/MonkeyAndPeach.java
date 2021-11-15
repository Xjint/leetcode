package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个猴子分100个桃子，每次拿一半
 *
 * @author baijintao
 * @date 2021/10/21 10:16 上午
 */
public class MonkeyAndPeach {

  private static final Lock lock = new ReentrantLock();

  private int count;

  public MonkeyAndPeach(int count) {
    this.count = count;
  }

  public int getPeach() throws InterruptedException {
    lock.lock();
    int get = count / 2;
    System.out.printf("%s拿到了%d个桃子，还剩%d个\n", Thread.currentThread().getName(), get, count - get);
    count -= get;
    lock.unlock();
    return get;
  }

  public static void main(String[] args) {
    System.out.println(-50 / 2);
    MonkeyAndPeach monkey = new MonkeyAndPeach(100);
    for (int i = 0; i < 3; i++) {
      new Thread(() -> {
        while (true) {
          try {
            if (!(monkey.getPeach() > 0)) {
              break;
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          try {
            Thread.sleep(3000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
      }).start();
    }
  }

}
