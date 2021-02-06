package java0.homework;

import java.util.concurrent.Semaphore;

public class Demo10_semaphore {
    private static volatile int result = 0;

    private int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    private final static Semaphore semaphore = new Semaphore(1);

    public Demo10_semaphore() throws InterruptedException {
        semaphore.acquire();
    }

    private void funcFibo() {
        result = fibo(5);
        semaphore.release();
    }

    private Integer getResult() throws InterruptedException {
        semaphore.acquire();
        semaphore.release();
        return result;
    }

    public static void main(String[] args) throws InterruptedException {

        Demo10_semaphore demo10 = new Demo10_semaphore();
        new Thread(() -> {
            demo10.funcFibo();
        }).start();

        System.out.println("输出结果：" + demo10.getResult());
        System.out.println("退出主函数！！！");

    }
}
