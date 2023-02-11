package com.shy.factory.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:01
 * @Description:
 */
public class Comsumer {
    public static void main(String[] args) {

//        Wuling car = new Wuling();
//        Tesla car2 = new Tesla();

        // 使用工厂创建
        Car car = CarFactory.getCar("五菱");
        Car car2 = CarFactory.getCar("特斯拉");

        car.name();
        car2.name();
    }
}
