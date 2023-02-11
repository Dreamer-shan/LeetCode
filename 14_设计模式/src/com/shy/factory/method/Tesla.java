package com.shy.factory.method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:00
 * @Description:
 */
public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
