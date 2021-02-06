package java0.homework;

public class Demo3_waitAndNotify {
    private static int result = 0;

    public synchronized void funcFibo() {
        result = fibo(5);
        this.notifyAll();
    }

    private synchronized Integer getResult() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        Demo3_waitAndNotify demo3 = new Demo3_waitAndNotify();
        new Thread(() -> {
            demo3.funcFibo();
        }).start();
        // 主线程调用get的时候，阻塞一下，等待demo3调用计算方法的时候，唤醒所有的线程，拿到结果
        System.out.println("输出结果：" + demo3.getResult());
        System.out.println("退出主函数！！！");
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
