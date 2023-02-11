import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/05/14:07
 * @Description:
 */
public class Main {
    private LinkedList<Integer> list = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition pro = lock.newCondition();
    private Condition con = lock.newCondition();
    public void put(int i){
        lock.lock();
        try {
            while (list.size() != 0){
                pro.await();
            }
            list.add(i);
            System.out.println(Thread.currentThread().getName()+"生产了"+list.peekFirst());
            con.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
