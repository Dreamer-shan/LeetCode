package com.shy.adapter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/15:46
 * @Description:
 */
// 客户端类  想上网  插不上网线
public class Computer {
    public void net(NetToUsb adapter){
        // 上网的具体实现  找一个转接头
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
//        Adapter adapter = new Adapter();
//        computer.net(adapter);

        Adapter2 adapter2 = new Adapter2(adaptee);
        computer.net(adapter2);
    }
}
