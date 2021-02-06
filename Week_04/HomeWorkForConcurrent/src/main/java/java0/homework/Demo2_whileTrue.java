package java0.homework;

public class Demo2_whileTrue {
    private static int result = 0;

    public void funcFibo() {
        result = fibo(5);
    }

    private Integer getResult() {
        while (true) {
            if (result != 0) {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        Demo2_whileTrue demo2 = new Demo2_whileTrue();
        new Thread(() -> {
            demo2.funcFibo();
        }).start();
        System.out.println("输出结果：" + demo2.getResult());
        System.out.println("退出主函数！！！");
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
