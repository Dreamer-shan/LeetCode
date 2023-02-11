package com.shy.factory.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:00
 * @Description:
 */
// 不同品牌的车实现接口
public class Tesla implements Car{
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
