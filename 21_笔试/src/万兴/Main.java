package 万兴;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        long time1 = arrayListFor();
        long time2 = arrayListItr();
        long time3 = linkedListFor();
        long time4 = linkedListItr();
        System.out.println("arrayListFor时间:" + time1);
        System.out.println("arrayListItr时间:" + time2);
        System.out.println("linkedListFor时间:" + time3);
        System.out.println("linkedListItr时间:" + time4);
    }
    public static long arrayListFor(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            Integer k = list.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long arrayListItr(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer k = iterator.next();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long linkedListFor(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            Integer k = list.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long linkedListItr(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer k = iterator.next();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}

