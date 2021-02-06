package java0.homework;

public class Demo4_sleep {
    private static int result = 0;

    public void funcFibo() {
        result = fibo(5);
    }

    private Integer getResult() {
        return result;
    }

    public static void main(String[] args) {
        Demo4_sleep demo4 = new Demo4_sleep();
        new Thread(() -> {
            demo4.funcFibo();
        }).start();
        try {
            // 主线程睡眠2s,此方式有点不太靠谱
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("输出结果：" + demo4.getResult());
        System.out.println("退出主函数！！！");
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
