package com.shy.factory.method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:14
 * @Description:
 */
public class WulingFactory implements  CarFactory{
    @Override
    public Car getCar() {
        return new Wuling();
    }
}
