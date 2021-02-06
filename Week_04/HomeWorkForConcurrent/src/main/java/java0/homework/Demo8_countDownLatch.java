package java0.homework;

import java.util.concurrent.CountDownLatch;

public class Demo8_countDownLatch {
    private static volatile int result = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    private Integer getResult() throws InterruptedException {
        countDownLatch.await();
        return result;
    }

    private void funcFibo() {
        result = fibo(5);
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        Demo8_countDownLatch demo8 = new Demo8_countDownLatch();

        new Thread(() -> {
            demo8.funcFibo();
        }).start();

        System.out.println("输出结果：" + demo8.getResult());
        System.out.println("退出主函数！！！");
    }
}
