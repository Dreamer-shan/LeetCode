package com.shy.proxy1;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/10:51
 * @Description:
 */
public class client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler pih = new ProxyInvocationHandler(host);
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }
}
