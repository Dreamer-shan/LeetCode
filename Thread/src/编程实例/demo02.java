//package 编程实例;
//
//import javax.swing.plaf.nimbus.State;
//import java.util.Objects;
//
///**
// * @author Shan
// * @Description
// * @create 2021-02-08 21:07
// */
//public class demo02 {
//    public static void main(String[] args) {
//
//    }
//}
//
//class Bank{
//    static double money = 1000;
//    private void Counter(double money){
//        Bank.money -= money;
//        System.out.println("柜台取钱" + money + "元，还剩" + Bank.money + "元！");
//    }
//    private void ATM(double money){
//        Bank.money -= money;
//        System.out.println("ATM取钱" + money + "元，还剩" + Bank.money + "元！");
//    }
//    public synchronized void Draw(double money, String mode) throws Exception {
//        if (money > Bank.money){
//            throw new Exception("取款金额"+money+",余额只剩"+Bank.money+"，取款失败");
//        }
//        if (Objects.equals(mode,"ATM")){
//            ATM(money);
//        }else {
//            Counter(money);
//        }
//    }
//    class PersonA implements Runnable{
//        Bank bank;
//        String mode;
//
//        public PersonA(Bank bank, String mode) {
//            this.bank = bank;
//            this.mode = mode;
//        }
//
//        @Override
//        public void run() {
//            while ()
//        }
//    }
//}
