package com.shy.factory.abstract1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:32
 * @Description:
 */
// 路由器产品接口
public interface IRouterProduct {
    void start();
    void shutdown();
    void openwifi();
    void setting();
}
