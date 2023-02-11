package 多线程编程实战.gaoji;

/**
 * @author Shan
 * @Description 生产者消费者-->利用缓冲区解决：管程法
 * @create 2021-02-08 11:33
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}


class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }
    // 生产

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->"+container.pop().id+"只鸡");
        }
    }
}

class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }
}

class SynContainer{
    Chicken[] chickens = new Chicken[10];
    int count = 1;
    public synchronized void  push(Chicken chicken){
        //
        if (count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Chicken pop(){
        // 判断能否消费
        if (count == 0){
            // 等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果可以消费
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}
