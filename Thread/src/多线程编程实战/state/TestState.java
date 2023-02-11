package 多线程编程实战.state;

/**
 * @author Shan
 * @Description
 * @create 2021-02-07 20:11
 */
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("、、、、");
        });

//        观察状态
        Thread.State state = thread.getState();
        // NEW
        System.out.println("state1 " + state);

//        观察启动后
        thread.start();
        state = thread.getState();
        // RUNNABLE
        System.out.println("state2 " + state);

//        只要线程不终止，就一直输出状态
        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            // 更新线程状态
            state = thread.getState();
            System.out.println(state);
        }
        // 退出循环时状态为 TERMINATED

        // 死亡后的线程不能再次启动
//        thread.start();
    }
}
