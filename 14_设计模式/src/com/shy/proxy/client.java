package com.shy.proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/10:51
 * @Description:
 */
public class client {
    public static void main(String[] args) {
//        Host host = new Host();
//        host.rent();

        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
