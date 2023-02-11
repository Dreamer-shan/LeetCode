package 多线程编程实战.syn;

/**
 * @author Shan
 * @Description
 * @create 2021-02-07 21:10
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "基金");
        Drawing you = new Drawing(account, 50, "你");
        Drawing friend = new Drawing(account, 100, "你朋友");
        you.start();
        friend.start();
    }
}

// 账户
class Account{
    int money;
    String name;
    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }
}

// 银行
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;
    public Drawing(Account account, int drawingMoney, String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money - drawingMoney < 0){
            System.out.println(Thread.currentThread().getName()+"钱不够了，取不了");
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 卡内余额=余额-你取的钱
        account.money = account.money - drawingMoney;
        // 你手里的钱
        nowMoney = nowMoney + drawingMoney;
        System.out.println(account.name+"余额为"+account.money);
        // Thread.currentThread().getName() == this.getName()
        System.out.println(this.getName()+"手里的钱："+nowMoney);
    }
}
