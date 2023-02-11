package com.shy.factory.abstract1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:36
 * @Description:
 */
public class HuaweiRouter implements IRouterProduct{
    @Override
    public void start() {
        System.out.println("启动华为路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器");
    }

    @Override
    public void openwifi() {
        System.out.println("启动华为路由器wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为路由器设置");
    }
}
