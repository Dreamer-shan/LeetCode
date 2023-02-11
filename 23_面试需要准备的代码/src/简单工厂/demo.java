package 简单工厂;



/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/25/14:57
 * @Description:
 */


class Wuling implements Car {

    @Override
    public void name() {
        System.out.println("wuling");
    }
}

class Tesla implements Car {

    @Override
    public void name() {
        System.out.println("tesla");
    }
}

class Factory {


    public static Car getCar(String name) {
        if ("wuling".equals(name)) {
            return new Wuling();
        } else if ("tesla".equals(name)) {
            return new Tesla();
        } else {
            return null;
        }
    }
}


public class demo {
    public static void main(String[] args) {
        Car wuling = Factory.getCar("wuling");
        Car tesla = Factory.getCar("tesla");
        wuling.name();
        tesla.name();
    }
}
