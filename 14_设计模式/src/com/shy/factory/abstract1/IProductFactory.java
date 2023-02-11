package com.shy.factory.abstract1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:38
 * @Description:
 */
// 抽象产品工厂
public interface IProductFactory {
    // 生产手机的接口
    IphoneProduct iphoneProduct();
    // 生产路由器的接口
    IRouterProduct routerProduct();
    // 生产笔记本的接口
}
