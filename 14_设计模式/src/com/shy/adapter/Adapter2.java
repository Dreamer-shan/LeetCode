package com.shy.adapter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/15:58
 * @Description:
 */
// 组合 对象适配器  常用
public class Adapter2 implements NetToUsb{

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}
