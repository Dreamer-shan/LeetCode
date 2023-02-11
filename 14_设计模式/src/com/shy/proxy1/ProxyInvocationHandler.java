package com.shy.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/22:05
 * @Description:
 */
// 用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    private Rent rent;
    public ProxyInvocationHandler(Rent rent){
        this.rent = rent;
    }
//     生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    // 处理代理实例，返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行"+method.getName()+"方法");
        //执行原对象的相关操作，容易忘记
        Object result = method.invoke(rent, args);
        System.out.println(method.getName()+"方法执行完毕");
        return result;
    }
}

