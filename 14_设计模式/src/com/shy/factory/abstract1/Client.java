package com.shy.factory.abstract1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:51
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("小米系列产品========================");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IphoneProduct iphoneProduct = xiaomiFactory.iphoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();

        IRouterProduct iRouterProduct = xiaomiFactory.routerProduct();
        iRouterProduct.openwifi();


        System.out.println("华为系列产品========================");
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        iphoneProduct = huaweiFactory.iphoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();

        iRouterProduct = huaweiFactory.routerProduct();
        iRouterProduct.openwifi();
    }
}

