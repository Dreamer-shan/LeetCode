package 多线程;

/**
 * @author Shan
 * @Description
 * @create 2021-02-06 22:22
 */
public class demo04ThreadAnywhere {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        System.out.println("主方法由当前线程执行: " + currentThread);
        Helper helper = new Helper("JAVA线程无处不在");
        helper.run();
    }
    static class Helper implements Runnable{
        private final String message;

        Helper(String message) {
            this.message = message;
        }
        private void doSomething(String message){
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            System.out.println("doSomething方法由该线程执行 " + currentThread);
            System.out.println("Do something with " + message);

        }
        @Override
        public void run() {
            doSomething(message);
        }
    }
}
