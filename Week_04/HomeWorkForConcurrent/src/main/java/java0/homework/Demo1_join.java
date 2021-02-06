package java0.homework;


public class Demo1_join {

    private static int result = 0;

    public static void main(String[] args) {
        JoyinThread joyinThread = new JoyinThread();
        joyinThread.start();

        try {
            joyinThread.join();
            System.out.println("输出结果：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退出主函数！！！");
    }

    static class JoyinThread extends Thread {
        @Override
        public void run() {
            result = fibo(5);
        }
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

}

