//package 爱奇艺;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/09/12/15:32
// * @Description:
// */
//
//import sun.misc.ConditionLock;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        final Scanner reader = new Scanner(System.in);
//        final String next = reader.next();
//        String[] orders = next.substring(1, next.length() - 1).split(",");
//        FooPrint foo = new FooPrint();
//        Thread thread1 = new Thread(() -> {
//            try {
//                foo.first(() -> System.out.print("first"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread thread2 = new Thread(() -> {
//            try {
//                foo.second(() -> System.out.print("second"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread thread3 = new Thread(() -> {
//            try {
//                foo.third(() -> System.out.print("third"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        List<Thread> threads = Arrays.asList(thread1, thread2, thread3);
//        for (int i = 0; i < orders.length; i++) {
//            threads.get(Integer.parseInt(orders[i]) - 1).start();
////            threads.get(Integer.parseInt(orders[i]) - 1).join();
//        }
//        reader.close();
//    }
//}
//
//class FooPrint {
//
////    ReentrantLock lock = new ReentrantLock();
////    Condition condition1 = lock.newCondition();
////    Condition condition2 = lock.newCondition();
////    Condition condition3 = lock.newCondition();
//    private AtomicInteger first = new AtomicInteger(0);
//    private AtomicInteger second = new AtomicInteger(0);
//    public FooPrint() {
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        //待实现
//        printFirst.run();
//        first.incrementAndGet();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        //待实现
////        condition3.signal();
////        condition2.await();
//        while (first.get() != 1){
//        }
//        printSecond.run();
//        second.incrementAndGet();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        //待实现
////        condition1.signal();
////        condition3.await();
//        while (second.get() != 1){
////[1,3,2]
////            firstsecondthird
//        }
//        printThird.run();
//    }
//}
