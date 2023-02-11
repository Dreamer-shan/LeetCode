package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Shan
 * @Description 读写锁的降级
 * 一个线程持有读写锁的写锁的情况下可以继续获得相应的读锁
 * @create 2021-02-06 23:20
 */
public class demo06ReadWriteLockDowngrade {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writerLock = rwLock.writeLock();
    public void operationWithLockDowngrade(){
        boolean readLockAcquired = false;
        // 申请写锁
        writerLock.lock();
        try {
            // 对共享数据进行更新
            // ...
            // 当前线程在持有写锁的情况下申请读锁readLock
            readLock.lock();
            readLockAcquired = true;
        }finally {
            writerLock.unlock();
        }
        if (readLockAcquired){
            try {

            }finally {
                readLock.unlock();
            }
        }else {
            //....
        }
    }



}
