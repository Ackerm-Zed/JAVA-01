package java0.homework;

import java.util.concurrent.CompletableFuture;

public class Demo5_completableFuture {
    private static int result = 0;

    public static int funcFibo() {
        return fibo(5);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    public static void main(String[] args) {
        result = CompletableFuture.supplyAsync(() -> funcFibo()).join();
        System.out.println("输出结果：" + result);
        System.out.println("退出主函数！！！");
    }
}
