package com.shy.factory.method;

import com.shy.factory.simple.CarFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:01
 * @Description:
 */
public class Comsumer {
    public static void main(String[] args) {
        Car car = new WulingFactory().getCar();
        Car car1 = new TeslaFactory().getCar();
        car.name();
        car1.name();
        Car car2 = new MobaiFactory().getCar();
        car2.name();
    }
}
