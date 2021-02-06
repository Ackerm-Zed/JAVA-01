package java0.homework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class Demo7_reEntrantLock {

    private static volatile Integer result = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    private Integer getResult() throws InterruptedException {
        lock.lock();
        try {
            while (result == 0) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
        return result;
    }

    private void funcFibo() {
        lock.lock();
        try {
            result = fibo(5);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo7_reEntrantLock demo7 = new Demo7_reEntrantLock();

        new Thread(() -> {
            demo7.funcFibo();
        }).start();

        System.out.println("输出结果：" + demo7.getResult());
        System.out.println("退出主函数！！！");
    }
}
