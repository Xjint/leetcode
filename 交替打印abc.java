/**
 * Created by jintao.bai on 2020/5/26 22:52
 */
public class 交替打印abc {
    /*两个线程交替打印ab 一共打印100次*/
    public static void print() throws InterruptedException {
        Object lock = new Object();
        Object se = new Object();
        Print printA = new Print("a", lock, se);
        Print printB = new Print("b", se, lock);
        new Thread(printA).start();
        new Thread(printB).start();
    }

    public static void main(String[] args) throws InterruptedException {
        print();
    }

    public static class Print implements Runnable {
        String name;
        Object lock;
        Object self;

        public Print(String name, Object lock, Object self) {
            this.name = name;
            this.lock = lock;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 100;
            while (count > 0) {
                synchronized (lock) {
                    synchronized (self) {
                        System.out.print(name);
                        --count;
                        self.notifyAll();
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
