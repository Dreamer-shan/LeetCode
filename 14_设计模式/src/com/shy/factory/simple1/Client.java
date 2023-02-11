package com.shy.factory.simple1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/17:30
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("奔驰");
        Car car1 = CarFactory.getCar("五菱");
        car.name();
        car1.name();


    }
}
