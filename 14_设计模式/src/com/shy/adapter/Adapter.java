package com.shy.adapter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/15:48
 * @Description:
 */
// 继承(类适配器，单继承  有局限性)
// 真正的适配器  需要连接usb  连接网线
public class Adapter extends Adaptee implements NetToUsb{

    @Override
    public void handleRequest() {
        super.request();
    }
}
