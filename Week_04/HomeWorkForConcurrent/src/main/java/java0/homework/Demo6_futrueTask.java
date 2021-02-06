package java0.homework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo6_futrueTask {
    private static int result = 0;

    public void funcFibo() {
        result = fibo(5);
    }

    public int getResult () {
        return result;
    }

    private int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo6_futrueTask demo6 = new Demo6_futrueTask();
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            demo6.funcFibo();
            return demo6.getResult();
        });
        new Thread(futureTask).start();
        System.out.println("输出结果：" + futureTask.get());
        System.out.println("退出主函数！！！");
    }

}
