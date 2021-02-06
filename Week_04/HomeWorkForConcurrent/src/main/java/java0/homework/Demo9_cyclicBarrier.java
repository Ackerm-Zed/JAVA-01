package java0.homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo9_cyclicBarrier {

    private static volatile Integer result = null;

    CyclicBarrier barrier = new CyclicBarrier(1, new Demo9Runnable());

    private Integer getResult() throws BrokenBarrierException, InterruptedException {
        barrier.await();
        return result;
    }

    public static void main(String[] args) {
        Demo9_cyclicBarrier demo9 = new Demo9_cyclicBarrier();

        new Thread(new Demo9Runnable()).start();

        try {
            result = demo9.getResult();
            System.out.println("输出结果：" + demo9.getResult());
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退出主函数！！！");
    }

    static class Demo9Runnable implements Runnable {

        @Override
        public void run() {
            result = fibo(5);
        }

        private int fibo(int a) {
            if (a < 2)
                return 1;
            return fibo(a - 1) + fibo(a - 2);
        }
    }

}
