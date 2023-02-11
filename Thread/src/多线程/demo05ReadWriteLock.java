package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Shan
 * @Description 读写锁的使用
 * @create 2021-02-06 23:02
 */
public class demo05ReadWriteLock {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void reader(){
        readLock.lock();
        try {
            // 读取共享变量
        }finally {
            // 总是在 finally 块中释放锁，避免锁泄露
            readLock.unlock();
        }
    }

    public void writer(){
        writeLock.lock();
        try {
            // 访问(读、写)共享变量
        }finally {
            writeLock.unlock();
        }
    }
}
